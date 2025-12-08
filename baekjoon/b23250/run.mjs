import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol2.js"
let inputCount = 1;

async function testF(inputFile, output, off=1e-9) {
  let cmd = command + " < " + inputFile
  let { stdout, stderr } = await exec(cmd);
  let label = inputFile != "data_temp" ? inputFile : "input" + inputCount++;
  let ok = (typeof output == "string") ? (stdout.trim() == output) :
    (typeof output == "number") ? (Math.abs(Number(stdout.trim()) - output) <= off) :
    (typeof output == "object") ? stdout.trim().split(/\s+/)
                                    .reduce((a,e,i)=>a && +e-output[i]<=off, true) :
    false;
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

await testS('1 1', '1 3');

await testS('2 1', '1 2');
await testS('2 2', '1 3');
await testS('2 3', '2 3');

await testS('3 1', '1 3');
await testS('3 2', '1 2');
await testS('3 3', '3 2');
await testS('3 4', '1 3');
await testS('3 5', '2 1');
await testS('3 6', '2 3');
await testS('3 7', '1 3');

await testS('4 1', '1 2');
await testS('4 2', '1 3');
await testS('4 3', '2 3');
await testS('4 4', '1 2');
await testS('4 5', '3 1');
await testS('4 6', '3 2');
await testS('4 7', '1 2');
await testS('4 8', '1 3');
await testS('4 9', '2 3');
await testS('4 10', '2 1');
await testS('4 11', '3 1');
await testS('4 12', '2 3');
await testS('4 13', '1 2');
await testS('4 14', '1 3');
await testS('4 15', '2 3');