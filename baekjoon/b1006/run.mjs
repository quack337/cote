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

await testFS('data1', '11')
await testFS('data2', '6')
await testFS('data3', '6\n6\n2\n10\n10')
await testFS('data4', '14\n13\n6\n6\n7')
await testFS('data5', '1\n7\n10\n12\n10')
await testFS('data6', '8\n13\n6\n11\n5')
await testFS('data7', '8\n10\n13\n9\n8')
await testSS(`1
1 10
1
1`, '1')
await testSS(`1
1 10
10
10`, '2')
await testSS(`1
2 10
1 1
1 1`, '2')
await testSS(`1
2 10
1 10
1 1`, '3')
await testSS(`1
2 10
1 1
1 10`, '3')
await testSS(`1
2 10
1 10
10 1`, '4')
await testSS(`1
2 10
10 10
1 1`, '3')
await testSS(`1
2 10
10 1
10 1`, '3')
await testSS(`1
2 10
1 1
10 10`, '3')
await testSS(`1
2 10
10 1
10 10`, '4')
await testSS(`1
2 10
10 10
10 10`, '4')