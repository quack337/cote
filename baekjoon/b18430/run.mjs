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

await testFS("data1", "632")
await testFS("data2", "0");

await testSS(`2 2
1 2
3 4`, "13");

await testSS(`1 4
1 2 3 4`, "0");

await testSS(`5 5
1 2 1 3 1
2 1 3 1 4
2 2 2 2 2
1 3 1 3 1
2 1 2 1 2`, "61");
