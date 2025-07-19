import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol.js"
//let command = "java Main.java"
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

await testFS('data1', 'HEART\nEMBER\nABUSE\nRESIN\nTREND')
await testFS('data2', 'NONE')
await testFS('data3', 'AAAAA\nAAAAA\nAAAAA\nAAAAA\nAAAAA')
await testFS('data4', 'HEART\nEMBER\nABUSE\nRESIN\nTRENT')
await testFS('data5', 'NONE')

await testSS(`2 4
DD
DD
AB
BC`,'AB\nBC')

await testSS(`2 4
DD
AB
DD
BC`,'AB\nBC')

await testSS(`2 4
BA
AB
BA
BC`,'AB\nBA')

await testSS(`2 4
AB
BA
AC
CA`,'AB\nBA')

await testSS(`2 4
AC
CA
AB
BA`,'AB\nBA')

await testSS(`2 4
AC
CA
AB
BD`,'AB\nBD')

await testSS(`3 4
AAC
BCD
CDE
DEF`,'BCD\nCDE\nDEF')