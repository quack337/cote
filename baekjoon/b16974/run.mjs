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

await testF('data1', '4');
await testF('data3', '2160549382716056');

await testS('0 0', '0');
await testS('0 1', '1');
await testS('0 2', '1');

await testS('1 0', '0');
await testS('1 1', '0');
await testS('1 2', '1');
await testS('1 3', '2');
await testS('1 4', '3');
await testS('1 5', '3');
await testS('1 6', '3');

await testS('2 0', '0');
await testS('2 1', '0');
await testS('2 2', '0');
await testS('2 3', '1');
await testS('2 4', '2');
await testS('2 5', '3');
await testS('2 6', '3');
await testS('2 7', '4');
await testS('2 8', '4');
await testS('2 9', '5');
await testS('2 10', '6');
await testS('2 11', '7');
await testS('2 12', '7');
await testS('2 13', '7');
await testS('2 14', '7');
