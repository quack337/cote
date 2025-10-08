import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol4.js"
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

await testSS('4\n2', 2);
await testSS('6\n3', 2);
await testSS('8\n4', 2);
await testSS('10\n5', 2);
await testSS('20\n10', 2);

await testSS('8\n0', 1);
await testSS('8\n1', 8);
await testSS('8\n2', 20);
await testSS('8\n3', 16);
await testSS('8\n4', 2);
await testSS('8\n5', 0);

await testSS('9\n0', 1);
await testSS('9\n1', 9);
await testSS('9\n2', 27);
await testSS('9\n3', 30);
await testSS('9\n4', 9);
await testSS('9\n5', 0);