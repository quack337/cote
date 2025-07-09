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

await testFS("data1", "Case 1: 10\nCase 2: 3")
await testSS("1 1\n.", "Case 1: 1");
await testSS("1 2\n..", "Case 1: 1");
await testSS("1 3\n...", "Case 1: 1");
await testSS("2 3\n...\n...", "Case 1: 3");
await testSS(`3 3
...
.**
...`, "Case 1: 3");
await testSS(`3 3
...
..*
...`, "Case 1: -1");
await testSS(`3 3
.*.
..*
...`, "Case 1: -1");