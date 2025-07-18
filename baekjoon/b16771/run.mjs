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

await testFS('data1', '5')
await testSS('1 1 1 1 1 1 1 1 1 1\n1 1 1 1 1 1 1 1 1 1', '1')
await testSS('1 1 1 1 1 1 1 1 1 1\n2 2 2 2 2 2 2 2 2 2', '3')
await testSS('1 2 3 4 5 6 7 8 9 10\n11 12 13 14 15 16 17 18 19 20', '37')
