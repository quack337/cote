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

await testFS('data1', '5')
await testFS('data2', '5')

await testSS('7 2 5\n0', '0');
await testSS('7 2 5\n1\n2', '0');
await testSS('7 2 5\n2\n2 5', '0');
await testSS('7 2 5\n3\n2 5 2', '0');
await testSS('7 2 5\n4\n2 5 2 2', '0');
await testSS('7 2 5\n5\n2 5 2 2 5', '0');

await testSS('7 1 2\n1\n3', '1');
await testSS('7 1 2\n1\n4', '2');

await testSS('7 3 6\n1\n7', '1');
await testSS('7 3 6\n1\n2', '1');
await testSS('7 3 6\n1\n1', '2');
await testSS('7 3 6\n1\n4', '1');
await testSS('7 3 6\n1\n5', '1');

await testSS('7 3 6\n2\n7 2', '2');
await testSS('7 3 6\n3\n7 2 6', '3');
await testSS('7 3 6\n3\n7 1 5', '5');

await testSS('7 2 5\n1\n3', '1');
await testSS('7 2 5\n2\n3 1', '3');
await testSS('7 2 5\n3\n3 1 6', '4');
await testSS('7 2 5\n4\n3 1 6 5', '5');

await testSS('7 1 2\n1\n7', '5');
await testSS('7 1 2\n2\n7 6', '6');
await testSS('7 1 2\n3\n7 6 5', '7');
await testSS('7 1 2\n4\n7 6 5 4', '8');

await testSS('3 1 2\n2\n3 1', '1');