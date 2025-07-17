import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol_short.js"
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

await testFS("data1", "1\n1\n0")
await testSS("1\na", "0");
await testSS("1\naa", "1");
await testSS("1\nbaa", "0");
await testSS("1\nbaab", "1");
await testSS("1\nabaab", "0");
await testSS("1\nabaabaa", "1");
await testSS("1\nbabaabaa", "0");
await testSS("1\nbbabaabaa", "1");
await testSS("1\nbbabaabaab", "1");
await testSS("1\nabbabaabaab", "1");
await testSS("1\nabbabaabaabaa", "1");
await testSS("1\nabbabaabaabaaabbabaabaabaa", "1");
