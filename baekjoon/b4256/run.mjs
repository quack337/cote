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
  await testF("data_temp", output);
}

await testF('data1', '2 4 1 3\n5 8 4 6 2 1 7 3');
await testF('data2', '5 8 4 6 2 1 7 3');
await testS('1\n1\n1\n1', '1');
await testS('1\n1\n2\n2', '2');

const F1=a=>!a ? '' : a[1]+' '+F1(a[0])+F1(a[2]);
const F2=a=>!a ? '' : F2(a[0])+a[1]+' '+F2(a[2]);
const F3=a=>!a ? '' : F3(a[0])+F3(a[2])+a[1]+' ';

let A=[
  1, [,1,],
  1, [,2,],
  3, [[,2,],1,[,3,]],
  3, [[[,3,],2,],1],
  3, [,1,[,2,[,3,]]],
  4, [,1,[,2,[,3,[,4,]]]],
  4, [[[[,4,],3,],2,],1],
  4, [[,2,],1,[[,4,],3,]],
  5, [[,2,[,5,]],1,[[,4,],3,]],
  5, [[[,5,],2,],1,[[,4,],3,]],
  5, [[[,5,],2,[,4,]],1,[,3,]],
  5, [[,2,[,4,]],1,[,3,[,5,]]],
  5, [[,2,[,4,]],1,[[,5,],3,]],
];
for (let i=0;;){
  let N=A[i++],a=A[i++];
  if(!N) break;
  await testS(`1\n${N}\n${F1(a).trim()}\n${F2(a).trim()}`, F3(a).trim());
}
