import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol2.js"
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

await testFS('data1', '10')
await testSS(
`2 2 1
1 2 3`, '3')
await testSS(
`3 3 2
1 2 3
2 3 4`, '7')
await testSS(
`3 3 3
1 2 3
1 3 6
2 3 4`, '7')
await testSS(
`3 3 3
1 2 3
1 3 8
2 3 4`, '8')
await testSS(
`3 3 6
1 2 1
1 3 1
2 1 1
2 3 1
3 1 1
3 2 1`, '2')
await testSS(
`4 2 4
1 2 3
1 3 3
1 4 3
3 4 4`, '3')
await testSS(
`4 3 4
1 2 3
1 3 3
1 4 3
3 4 4`, '7')
await testSS(
`4 3 4
1 2 3
1 3 3
1 4 8
3 4 4`, '8')
await testSS(
`4 3 4
1 2 3
1 3 3
1 4 8
3 4 6`, '9')
await testSS(
`4 4 4
1 2 9
1 3 9
1 4 1
2 3 9`, '1')