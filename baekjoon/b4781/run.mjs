import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol_fast.js"
let inputCount = 1;

async function testFS(inputFile, outputString) {
  let cmd = command + " < " + inputFile
  let { stdout, stderr } = await exec(cmd);
  let label = inputFile != "data_temp" ? inputFile : "input" + inputCount++;
  if (stdout.trim() == outputString)
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

await testFS('data1', '796\n798')

await testSS(`1 0.01
5 0.01
0`, 5)

await testSS(`1 0.02
5 0.01
0`, 10)

await testSS(`1 0.03
5 0.01
0`, 15)

await testSS(`2 0.02
5 0.01
11 0.02
0`, 11)

await testSS(`2 0.02
5 0.01
9 0.02
0`, 10)

await testSS(`3 0.03
5 0.01
9 0.02
16 0.03
0`, 16)

await testSS(`3 0.04
2 0.01
9 0.03
10 0.04
0`, 11)
