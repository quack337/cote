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

await testFS("data1", "3")
await testFS("data2", "1")
await testFS("data3", "6")
await testFS("data4", "20")

await testSS(`5 4
1 2
1 3
1 4
1 5`, '3')

await testSS(`5 2
1 2
3 4`, '5')

await testSS(`5 2
1 2
1 3`, '3')

await testSS(`8 5
1 2
2 3
3 4
4 7
5 6`, '7')

await testSS(`7 5
1 2
2 3
3 4
4 7
5 6`, '7')

await testSS(`4 6
1 2
2 3
3 4
4 1
2 4
1 3`, '4')

await testSS(`5 4
1 2
1 3
1 4
1 5`, '3')

await testSS(`19 1
1 2`, '3')

await testSS(`6 4
1 2
2 3
4 5
6 1
`, '6')

await testSS(`6 6
1 2
2 3
3 1
4 5
5 6
6 4`, '5')

await testSS(`5 6
2 3
2 4
2 5
3 4
4 5
1 2`, '5')

await testSS('2 0', '1')

/*
await testSS(`

`, '')
*/