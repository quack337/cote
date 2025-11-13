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

await testFS('data1', '252')
await testFS('data2', '2')
await testFS('data3', '6406484391866534976')
await testFS('data4', '0')
await testSS(`1 1
0`, '2');
await testSS(`1 1
1
0 0 0 1`, '1');
await testSS(`1 1
1
0 0 1 0`, '1');
await testSS(`1 1
2
0 0 1 0
0 0 0 1`, '0');

await testSS(`2 2
0`, '6');
await testSS(`3 3
0`, '20');
await testSS(`4 5
0`, '126');