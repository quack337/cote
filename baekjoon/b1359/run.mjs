import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol.js"
let inputCount = 1;

async function testF(inputFile, output) {
  let cmd = command + " < " + inputFile
  let { stdout, stderr } = await exec(cmd);
  let label = inputFile != "data_temp" ? inputFile : "input" + inputCount++;
  let ok = (typeof output == "string") ?
    (stdout.trim() == outputString) :
    (Math.abs(Number(stdout.trim()) - output) <= 1e-9);
  if (ok)
    console.log(label, true);
  else {
    console.log(label, false, stdout);
    process.exit(1);
  }
}

async function testS(inputString, output) {
  fs.writeFileSync("data_temp", inputString);
  await testF("data_temp", output);
}

await testF('data1', 0.3333333333333333);
await testF('data2', 1.0);
await testF('data3', 0.4642857142857143);
await testF('data4', 0.7571428571428571);

await testS('2 1 1', 0.5);

await testS('3 1 1', 0.3333333333333333);
await testS('3 2 1', 1);
await testS('3 2 2', 0.3333333333333333);

await testS('4 1 1', 0.25);
await testS('4 2 1', 0.8333333333333333);
await testS('4 2 2', 0.1666666666666666);
await testS('4 3 1', 1);
