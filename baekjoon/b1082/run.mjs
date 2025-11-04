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

await testFS('data1', '210');
await testFS('data2', '20');
await testFS('data3', '0');
await testFS('data4', '99999999999999999999999999999999999999999999999999');

await testSS('1\n10\n10', '0');
await testSS('1\n10\n20', '0');
await testSS('2\n10 10\n20', '11');
await testSS('2\n9 10\n19', '10');
await testSS('2\n9 10\n9', '0');
await testSS('3\n9 10 11\n20', '20');
await testSS('3\n9 10 11\n19', '10');
await testSS('3\n1 1 3\n3', '111'); 
await testSS('2\n1 2\n3', '10'); 

await testSS('3\n1 2 3\n3', '10'); 
// 이 반례에서 sol1 버그
// n=1 일때 '10'을 리턴하지 않고 '000'을 리턴한다.
//   '110' 보다 '1000'이 더 크기 때문이다.

await testSS('3\n1 2 3\n4', '100'); 
await testSS('3\n1 2 3\n5', '1000'); 

await testSS('5\n1 2 2 3 3\n20', '2000000000000000000');
await testSS('4\n9 7 8 9\n20', '33');
await testSS('3\n6 7 8\n21', '210');
await testSS('3\n5 23 24\n30', '20');
await testSS('4\n1 5 3 2\n1', '0');
await testSS('10\n1 1 1 1 1 1 1 1 1 1\n50', '99999999999999999999999999999999999999999999999999');
await testSS('5\n1 2 3 4 5\n15', '10000000000000');
await testSS('4\n1 5 3 2\n2', '3');
await testSS('3\n50 50 1\n50', '22222222222222222222222222222222222222222222222222');
await testSS('2\n1 50\n50', '1');
await testSS('2\n2 1\n10', '1111111111');
await testSS('3\n6 7 8\n22', '220');
await testSS('1\n10\n20', '0');
await testSS('3\n6 7 8\n7', '1');
await testSS('3\n6 7 8\n6', '0');
await testSS('5\n1 2 2 3 3\n20', '2000000000000000000');
await testSS('3\n10 30 50\n20', '0');
await testSS('10\n6 32 38 18 12 6 7 8 6 7\n50', '99888888');
await testSS('1\n1\n1', '0');
await testSS('4\n9 7 8 9\n20', '33');

await testSS('1\n1\n50', '0');
await testSS('2\n1 1\n50', '11111111111111111111111111111111111111111111111111');
await testSS('1\n10\n20', '0');
await testSS('3\n6 7 8\n22', '220');

await testSS('10\n6 32 38 18 12 6 7 8 6 7\n50', 99888888);
await testSS('3\n10 30 50\n20', 0);
await testSS('5\n1 2 2 3 3\n20', '2000000000000000000');
await testSS('2\n1 50\n50', 1);