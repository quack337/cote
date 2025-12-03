import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol.js"
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
  await testF("data_temp", output)
}

await testF('data1', 19);
await testF('data2', 3);
await testF('data3', 8);
await testF('data4', 0);
await testF('data5', 0);
await testF('data6', 7);

await testS('1', 1);
await testS('12', 2);
await testS('123', 3);

await testS('2()', 0);
await testS('2(1)', 2);
await testS('3(1)', 3);
await testS('2(11)', 4);

await testS('12()', 1);
await testS('12(1)', 3);
await testS('13(1)', 4);
await testS('12(11)', 5);

await testS('2()1', 1);
await testS('2(1)1', 3);
await testS('3(1)1', 4);
await testS('2(11)1', 5);

await testS('2(2())', 0);
await testS('2(2(1))', 4);
await testS('2(3(1))', 6);
await testS('2(2(11))', 8);

await testS('12(2())', 1);
await testS('12(2(1))', 5);
await testS('12(3(1))', 7);
await testS('12(2(11))', 9);

await testS('2(2())1', 1);
await testS('2(2(1))1', 5);
await testS('2(3(1))1', 7);
await testS('2(2(11))1', 9);

await testS('2(12())', 2);
await testS('2(12(1))', 6);
await testS('2(13(1))', 8);
await testS('2(12(11))', 10);