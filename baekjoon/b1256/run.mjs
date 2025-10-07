import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol3.js"
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

await testSS('2 2 1', 'aazz');
await testSS('2 2 2', 'azaz');
await testSS('2 2 3', 'azza');
await testSS('2 2 4', 'zaaz');
await testSS('2 2 5', 'zaza');
await testSS('2 2 6', 'zzaa');
await testSS('2 2 7', '-1');
await testSS('2 2 8', '-1');

await testSS('2 1 1', 'aaz');
await testSS('2 1 2', 'aza');
await testSS('2 1 3', 'zaa');
await testSS('2 1 4', '-1');
await testSS('2 1 5', '-1');

await testSS('1 1 1', 'az');
await testSS('1 1 2', 'za');
await testSS('1 1 3', '-1');
await testSS('1 1 4', '-1');

await testSS('1 2 1', 'azz');
await testSS('1 2 2', 'zaz');
await testSS('1 2 3', 'zza');
await testSS('1 2 4', '-1');
await testSS('1 2 5', '-1');

await testSS('10 10 1000000000', '-1');
await testSS('7 4 47', 'aaazazaazaz');
