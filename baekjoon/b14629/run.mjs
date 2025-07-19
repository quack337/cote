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

await testFS('data1', '329')
await testSS('12', '12')
await testSS('3', '3')
await testSS('50', '50')
await testSS('500', '501')
await testSS('5000', '5012')
await testSS('5555', '5601')
await testSS('9', '9')
await testSS('99', '98')
await testSS('999', '987')
await testSS('9999', '9876')
await testSS('99999', '98765')
await testSS('987654312', '987654312')
await testSS('99999999999', '9876543210')
await testSS('10000000000', '9876543210')
await testSS('1000000000', '987654321')