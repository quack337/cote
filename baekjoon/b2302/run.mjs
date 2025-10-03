import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol_short.js"
let inputCount = 1;

async function testFS(inputFile, outputString) {
  let cmd = command + " < " + inputFile
  let { stdout, stderr } = await exec(cmd);
  let label = inputFile != "data_temp" ? inputFile : "input" + inputCount++;
  if (stdout.trim() == outputString)
    console.log(label, true);
  else {
    console.log(label, false, stdout);
    process.exit(1);
  }
}


async function testSS(inputString, outputString) {
  fs.writeFileSync("data_temp", inputString);
  await testFS("data_temp", outputString);
}

const nl = s=>s.replace(/ /g, '\n')

await testFS('data1', '12')
await testSS(nl('1 0'), '1');
await testSS(nl('1 1 1'), '1');
await testSS(nl('2 0'), '2');
await testSS(nl('2 1 1'), '1');
await testSS(nl('3 0'), '3');
