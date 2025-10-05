import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol2_short.js"
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

await testFS('data1', '54')
//await testFS('data2', '1000')
await testFS('data3', '100000000')

await testSS('1 2', '2');
await testSS('1 3', '3');
await testSS('1 -4', '-4');
await testSS('1 -3', '-3');
await testSS('1 0', '0');

await testSS('2 1 2', '3');
await testSS('2 -1 2', '2');
await testSS('2 2 -1', '2');
await testSS('2 -2 -3', '-2');
await testSS('2 0 0', '0');
await testSS('2 -1 0', '0');
await testSS('2 0 -1', '0');

await testSS('3 1 2 3', '6');
await testSS('3 -1 2 3', '5');
await testSS('3 1 -2 3', '4');
await testSS('3 1 2 -3', '3');
await testSS('3 1 -2 -3', '1');
await testSS('3 -1 2 -3', '2');
await testSS('3 -1 -2 3', '3');
await testSS('3 -1 -2 -3', '-1');

await testSS('4 -3 1 2 -1', '3');
await testSS('4 -3 -1 2 -1', '2');
await testSS('4 2 -1 2 -1000', '4');

await testSS('6 3 -5 5 -4 5 4', '14');
await testSS('8 1 -3 4 8 -4 -3 9 2', '20');
await testSS('10 1 -4 1 7 -9 -10 -2 8 2 -2', '10');
await testSS('10 1 -1 1 -1 1 -1 1 -1 1 -1', '2');
