import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol3.js"
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
await testSS('2', '2');
await testSS('3', '3');
await testSS('4', '5');
await testSS('5', '8');
await testSS('6', '13');
// 10000 00100 00001
// 00111 10011 11001 11100
// 1111

await testSS('6', '8');
// 000000 111111
// 110000 100100 100001
// 001100 001001
// 000011
// 111100 110011 111100