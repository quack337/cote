import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol.js"
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

await testSS('3 12 10 4', '2');
await testSS('3 10 12 4', '2');
await testSS('3 4 10 12', '2');
await testSS('3 4 12 10', '2');

await testSS('3 54 18 6' , '6');
await testSS('3 18 54 6' , '6');
await testSS('3 54 6 18' , '6');
await testSS('3 6 18 54' , '6');

await testSS('1 60', '7');
await testSS('3 1 1 1', '1');
await testSS('2 60 40', '9');
