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

await testFS('data1', '4')
await testSS('1 1\n1', '1');
await testSS('1 1\n0', '0');
await testSS('2 2\n11\n11', '4');
await testSS('2 2\n01\n11', '1');
await testSS('2 2\n10\n11', '1');
await testSS('2 2\n11\n01', '1');
await testSS('2 2\n11\n10', '1');
await testSS('3 3\n111\n111\n111', '9');
await testSS('3 3\n011\n111\n111', '4');
await testSS('3 3\n101\n111\n111', '4');
await testSS('3 3\n110\n111\n111', '4');
await testSS('3 3\n111\n011\n111', '4');
await testSS('3 3\n111\n110\n111', '4');
await testSS('3 3\n111\n111\n011', '4');
await testSS('3 3\n111\n111\n101', '4');
await testSS('3 3\n111\n111\n110', '4');
await testSS('1 3\n111', '1');
await testSS('1 3\n011', '1');
await testSS('1 3\n101', '1');
await testSS('1 3\n110', '1');
await testSS('1 3\n001', '1');
await testSS('1 3\n100', '1');
await testSS('1 3\n010', '1');
await testSS('1 3\n000', '0');


await testSS(`3 3
111
101
1111`, '1');
await testSS(`3 3
011
111
110`, '4');
await testSS(`3 3
011
011
110`, '4');
await testSS(`3 3
011
111
000`, '4');
await testSS(`3 3
010
111
010`, '1');
await testSS(`3 3
000
000
000`, '0');