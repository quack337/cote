import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let cmd1 = "node sol2.js"
let cmd2 = "node sol4.js"

async function testCCF(file) {
  let out1 = (await exec(cmd1 + " < " + file)).stdout.trim();
  let out2 = (await exec(cmd2 + " < " + file)).stdout.trim()
  let label = "run with " + file;
  if (out1 == out2)
    ;//console.log(label, true);
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

async function testCCS(inputString) {
  fs.writeFileSync("data_temp", inputString);
  await testCCF("data_temp");
}

let M=[,1,3]
for(let i=3;i<=60;++i)M[i]=M[i-1]*2+1;
for(let N=1;N<=60;++N){console.log(N);
for(let K=1;K<=M[N];++K)
  await testCCS(`${N} ${K}`);
}