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

await testFS('data1', '3\n5\n3\n1')
await testFS('data2', '11\n21\n10\n1\n33\n52\n36\n30\n53\n28\n61\n70')
await testSS(`1
1 1 1`, '1\n1');
await testSS(`1
1 1 1`, '1\n1');
await testSS(`2
1 1 1
2 2 2`, '2\n2\n1');
await testSS(`3
1 1 1
2 2 2
3 3 3`, '3\n3\n2\n1');
await testSS(`3
1 1 1
3 2 2
2 3 3`, '2\n3\n1');
