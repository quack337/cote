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

await testFS('data1', '17\n4 2 2')
await testSS('3 1\n1 2 3', '6\n3');
await testSS('3 2\n1 2 3', '3\n2 1');
await testSS('5 1\n1 2 3 4 5', '15\n5');
await testSS('5 2\n1 2 3 4 5', '9\n3 2');
await testSS('5 3\n1 2 3 4 5', '6\n3 1 1');
await testSS('5 4\n1 2 3 4 5', '5\n1 2 1 1');
await testSS('6 1\n1 2 3 4 5 6', '21\n6');
await testSS('6 2\n1 2 3 4 5 6', '11\n4 2');
await testSS('6 3\n1 2 3 4 5 6', '9\n3 2 1');
await testSS('6 4\n1 2 3 4 5 6', '6\n3 1 1 1');
await testSS('6 5\n1 2 3 4 5 6', '6\n1 2 1 1 1');
