import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let cmd1 = "node sol2.js"
let cmd2 = "python sol.py"

async function testCCF(file) {
  let out1 = (await exec(cmd1 + " < " + file)).stdout.trim();
  let out2 = (await exec(cmd2 + " < " + file)).stdout.trim()
  let label = "run with " + file;
  if (out1 == out2)
    console.log(label, true);
  else {
    console.log(label, false);
    process.exit(1);
  }
}

async function testCCFN(file, off=1e-9) {
  let out1 = (await exec(cmd1 + " < " + file)).stdout.trim();
  let out2 = (await exec(cmd2 + " < " + file)).stdout.trim()
  let ok = Math.abs(Number(out1) - Number(out2)) <= off;
  let label = "run with " + file;
  if (ok)
    ;//console.log(label, true);
  else {
    console.log(label, false);
    process.exit(1);
  }
}

async function testCCSN(inputString) {
  fs.writeFileSync("data_temp", inputString);
  await testCCFN("data_temp");
}

for (let i=1; i<20; ++i) {
  let file = "data"+i;
  if (fs.existsSync(file))
    await testCCFN(file);
}

for(let N=2;N<=500;++N)
for(let M=0;M<=N*20;++M)
for(let S=1;S<=N;++S)
for(let E=1;E<=N;++E) {
  console.log(N,M,S,E);
  await testCCSN(`${N} ${M}\n${S} ${E}`);
}