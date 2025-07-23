import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol_eq.js"
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

await testFS('data1', '75')
await testSS('1\n1', '1');
await testSS('2\n1\n2', '3');
await testSS('2\n2\n1', '3');
await testSS('3\n1\n2\n3', '5');
await testSS('3\n3\n2\n1', '4');
await testSS('4\n1\n2\n3\n4', '8');
await testSS('4\n4\n3\n2\n1', '8');
await testSS('5\n1\n2\n3\n4\n5', '12');
await testSS('5\n5\n4\n3\n2\n1', '12');

