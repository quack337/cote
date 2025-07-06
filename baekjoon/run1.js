import fs from 'fs';
import util from 'util';
import cp from 'child_process';
let exec = util.promisify(cp.exec);

let command = "node sol.js"

async function testFS(inputFile, outputString) {
  let cmd = command + " < " + inputFile
  let { stdout, stderr } = await exec(cmd);
  if (stdout.trim() == outputString)
    console.log(inputFile, true);
  else {
    console.log(inputFile, false, stdout);
    process.exit(1);
  }
}

async function testSS(inputString, outputString) {
  fs.writeFileSync("data_temp", inputString);
  testFS("data_temp", outputString);
}

await testFS("data1", "1 1 0 0")
await testFS("data2", "1 1 1 1")
await testFS("data3", "0 0 0 0")
await testFS("data4", "0 0 0 0")
await testFS("data5", "0 0 0 0")
await testFS("data6", "1 1 1 1")
await testFS("data7", "0 0 0 0")
await testFS("data8", "1 1 1 1")
await testFS("data9", "0 0 0 0")
