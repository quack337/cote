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

await testF('data1', '0 4 1');
await testF('data2', '1 1 1');
await testF('data3', '2 1 1');
await testF('data4', '2 4 3');
await testS('1\n0\n2\n1', '1 1 1');
await testS('1\n0\n0\n0', '1 0 0');
await testS('2\n0\n0\n0', '0 1 0');
await testS('3\n0\n0\n0', '0 0 1');
