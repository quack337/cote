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

await testFS('data1', '3')
await testFS('data2', '10200')
await testFS('data3', '9999')
await testFS('data4', '100')
await testFS('data5', '100')
await testFS('data6', '100')

await testSS('1 1 1\n1', '1')
await testSS('1 1 1\n2', '1')
await testSS('1 1 1\n3', '2')
await testSS('1 1 2\n3', '1')
await testSS('1 1000000 0\n1000000', '1000000000000')
await testSS('1 1000000 2\n1000000', '999998000000')
await testSS('2 10 0\n1 2', '7')
await testSS('2 11 0\n1 2', '8')
await testSS('2 12 0\n1 2', '8')
await testSS('2 12 1\n1 3', '8')
await testSS('2 12 2\n2 3', '8')
await testSS('2 13 2\n2 3', '9')