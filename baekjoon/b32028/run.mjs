import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "java Main.java"
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

async function testFF(inputFile, outputFile) {
  let out = fs.readFileSync(outputFile).toString();
  testF(inputFile, out);
}

await testF('data1', '-1 -1\n1 3\n-1 -1');
await testF('data2', '-1');
await testF('data3', '-1');
await testFF('data10', 'out10');
await testFF('data11', 'out11');
await testFF('data12', 'out12');

await testS(`1
1 1`,'-1 -1');

await testS(`1
1 10`,'-1');

await testS(`1
10 1`,'-1 -1');


await testS(`1
1 2`,'-1');

await testS(`2
10 1
20 2`,'-1 2\n-1 -1');

await testS(`2
20 1
10 2`,'2 -1\n-1 -1');

await testS(`2
10 2
20 1`, '-1 -1\n1 -1');

await testS(`2
20 2
10 1`,'-1 -1\n-1 1');

await testS(`2
20 1
10 1`,'-1');

await testS(`3
2000000000 2
0 1
-2000000000 2`,'-1 -1\n3 1\n-1 -1');

await testS(`3
10 1
20 2
30 2`,'-1');

await testS(`3
10 2
20 1
30 2`,'-1 -1\n1 3\n-1 -1');

await testS(`3
10 1
20 2
30 3`,'-1 2\n-1 3\n-1 -1');

await testS(`3
10 3
20 2
30 1`,'-1 -1\n1 -1\n2 -1');

await testS(`3
10 2
20 2
30 1`,'-1');

await testS(`3
10 1
20 2
30 2`,'-1');

await testS(`3
10 1
20 2
30 2`,'-1');

await testS(`4
10 2
20 1
30 2
40 3`,'-1 -1\n1 3\n-1 4\n-1 -1');

await testS(`4
10 1
20 2
30 3
40 4`,'-1 2\n-1 3\n-1 4\n-1 -1');

await testS(`4
10 4
20 3
30 2
40 1`,'-1 -1\n1 -1\n2 -1\n3 -1');

await testS(`4
10 1
20 3
30 2
40 4`,'-1');

await testS(`4
10 1
20 2
30 4
40 3`,'-1 2\n-1 4\n-1 -1\n3 -1');

await testS(`4
10 4
20 2
30 1
40 3`,'-1');

await testS(`4
10 3
20 2
30 1
40 2`,'-1 -1\n1 -1\n2 4\n-1 -1');
