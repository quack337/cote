import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol.js"
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

await testFS('data1', '5')
await testFS('data2', '4')
await testFS('data3', '-1')
await testFS('data4', '4')
await testFS('data5', '1')
await testFS('data6', '2')
await testFS('data7', '-1')
await testFS('data8', '-1')
await testFS('data9', '6')

await testSS(`1 1\n1`, 1);
await testSS(`1 2\n1H`, 1);
await testSS(`1 2\n11`, -1);
await testSS(`1 2\n12`, 2);
await testSS(`1 2\n21`, 1);

await testSS(`1 3\n1H2`, 1);
await testSS(`1 3\n2H1`, 2);
await testSS(`1 3\n2H2`, -1);
await testSS(`1 3\n231`, 3);

await testSS(`3 2
12
HH
31`,4);
