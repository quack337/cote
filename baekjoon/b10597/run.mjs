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

await testFS("data1", "4 1 11 10 9 8 7 6 5 3 2")
await testSS("1", "1");
await testSS("12", "1 2");
await testSS("123", "1 2 3");
await testSS("123456789", "1 2 3 4 5 6 7 8 9");
await testSS("12345678910", "1 2 3 4 5 6 7 8 9 10");
await testSS("1234567891011", "1 2 3 4 5 6 7 8 9 10 11");
await testSS("1012345678911", "10 1 2 3 4 5 6 7 8 9 11");
