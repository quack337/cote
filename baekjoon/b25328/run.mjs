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

await testFS('data1', 'a')
await testFS('data2', 'a\nb')
await testFS('data3', 'ac\ncd\nce\nde')
await testFS('data4', '-1')

await testSS(
`a
b
c
1`, '-1')

await testSS(
`abc
cba
cde
2`, '-1')

await testSS(
`abce
adbc
abec
3`, 'abc\nabe')