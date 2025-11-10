import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol5.js"
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

await testFS('data1', '27')
await testFS('data2', '7')
await testFS('data3', '200')
await testFS('data4', '1000000');

await testSS('1 1\n1 1 1', '1');
await testSS('1 3\n1 1 3', '3');
await testSS(`2 3
1 1 3
1 2 3`, '6');
await testSS(`2 11
1 1 10
10 20 10`, '21');
await testSS(`2 9
5 7 2
3 4 2`, 11);