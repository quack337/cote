import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol2.js"
let inputCount = 1;

async function testFS(inputFile, outputString) {
  let cmd = command + " < " + inputFile
  let { stdout, stderr } = await exec(cmd);
  let label = inputFile != "data_temp" ? inputFile : "input" + inputCount++;
  if (Math.abs(+stdout.trim() - outputString) <= 1e-9)
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

await testFS('data1', 1)
await testFS('data2', 1)
await testFS('data3', 0.30065359477124187)
await testFS('data4', 0.03502883081830450)
//await testSS('1\n5000\n2500', 1)

await testSS('5\n1 1 1 1 1\n2', 0)
await testSS('1\n50\n50', 1)
await testSS('2\n50 50\n5', 0.05628449443)
await testSS('1\n10 10\n20', 0)
