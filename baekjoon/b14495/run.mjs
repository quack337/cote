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

await testSS('1', '1');
await testSS('2', '1');
await testSS('3', '1');
await testSS('4', '2');
await testSS('5', '3');
await testSS('6', '4');
await testSS('7', '6');
await testSS('8', '9');
await testSS('9', '13');
await testSS('10', '19');
await testSS('116', '7536815746437618530');