import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

//let command = "node sol.js"
let command = "java Main.java"
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

await testFS("data1", "16");
await testFS("data2", "16");
await testFS("data3", "256");
await testFS("data4", "320");
await testFS("data5", "1");
await testFS("data6", "4096");
await testFS("data7", "262144");

await testSS("1\n1", "1");
await testSS("1\n2", "2");
await testSS("2\n1 1\n1 1", "4");
await testSS("2\n1 2\n2 1", "2");
await testSS("2\n1 1\n2 2", "4");
await testSS("2\n2048 2048\n2048 2048", "8192");
await testSS(`4
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1`, "16");
await testSS(`8
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
`, "64");
await testSS(`3
8 2 2
4 4 4
1 1 1
`, '16');