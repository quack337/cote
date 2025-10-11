import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol_expr.js"
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

await testFS('data1', '240')
await testSS(`10
1 2 3 4 5 6 7 8 9 10
3`, 54);
await testSS(`10
1 2 3 4 5 6 7 8 9 10
1`, 27);
await testSS(`10
0 0 0 0 0 0 0 0 0 0
2`, 0);
await testSS(`9
1 2 3 4 5 6 7 8 9
3`, 45);
await testSS(`15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1`, 42);
await testSS(`15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
2`, 75);
await testSS(`15
3 6 7 8 9 5 10 11 12 1 2 13 14 15 4
3`, 99);
await testSS(`4
2 95 46 69
1`,210);
await testSS(`9
26 6 25 18 18 18 4 44 68
1`,138);
await testSS(`7
2 100 100 2 2 2 2
2`, 208);
await testSS(`8
43 5 21 88 54 86 92 59
2`,400);
await testSS(`20
1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
1`, 15);
await testSS(`20
1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
2`, 27);
await testSS(`20
1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
3`, 36);
await testSS(`20
1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
4`, 42);
await testSS(`20
1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
5`, 45);
await testSS(`20
1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5
0`, 0);
await testSS(`20
0 1 0 0 0 0 0 1 0 0 0 0 0 0 1 0 0 0 0 0
3`, 3);
await testSS(`20
0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0
3`, 1);