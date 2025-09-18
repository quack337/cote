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

//await testFS('data1', '35')

await testSS(`2
0 1
2 0`, '1')
await testSS(`3
0 1 2
2 0 1
2 2 0`, '2')
await testSS(`3
0 2 3
3 0 2
3 3 0`, '4')
await testSS(`3
0 2 3
3 0 2
3 3 0`, '4')
await testSS(`3
0 1 0
0 0 2
0 0 0`, '3')


await testSS(`4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0`, 'Infinity')
await testSS(`4
0 0 2 0
0 0 0 0
0 3 0 0
1 0 0 0`, '6')
await testSS(`4
0 3 2 0
3 0 3 0
0 3 0 3
1 0 3 0`, '6')
