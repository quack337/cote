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

await testFS('data1', '140\n1 3 5 7')
await testFS('data2', '40\n1 2 3 4')

//await testSS('0\n', '0')
await testSS('1\n10', '10\n1')
await testSS('2\n10 20\n1 2', '20\n2')
await testSS('3\n10 20 30\n1 2\n2 3', '40\n1 3')
await testSS('4\n10 20 30 40\n1 2\n1 3\n1 4', '90\n2 3 4')
await testSS('5\n10 20 30 40 50\n1 2\n2 3\n3 4\n4 5', '90\n1 3 5')

await testSS(`6
10 20 15 25 30 10
1 2
1 3
2 4
2 5
3 6`, '75\n1 4 5 6')
