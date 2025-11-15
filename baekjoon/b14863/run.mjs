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

await testFS('data1', '660')
await testFS('data2', '5900')
await testFS('data3', '2735')

await testSS(
`1 10
20 200 10 100`, '100');

await testSS(
`1 20
20 200 10 100`, '200');

await testSS(
`2 20
20 300 5 100
15 250 10 100`, '350');

await testSS(
`3 200
50 200 20 100
80 370 30 120
70 250 30 90`, '820');

await testSS(
`3 190
50 200 20 100
80 370 30 120
70 250 30 90`, '720');

await testSS(
`3 180
50 200 20 100
80 370 30 120
70 250 30 90`, '720');

await testSS(
`3 160
50 200 20 100
80 370 30 120
70 250 30 90`, '660');

await testSS(
`3 150
50 200 20 100
80 370 30 120
70 250 30 90`, '570');

await testSS(
`3 140
50 200 20 100
80 370 30 120
70 250 30 90`, '560');

await testSS(
`3 120
50 200 20 100
80 370 30 120
70 250 30 90`, '470');

await testSS(
`3 110
50 200 20 100
80 370 30 120
70 250 30 90`, '410');

await testSS(
`3 100
50 200 20 100
80 370 30 120
70 250 30 90`, '310');

await testSS(
`3 80
50 200 20 100
80 370 30 120
70 250 30 90`, '310');