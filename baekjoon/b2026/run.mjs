import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
import gd from './generate_data.js';
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

await testFS("data1", "1\n2\n3\n6")
await testFS("data2", "1")

await testSS("2 2 0", "-1");
await testSS("2 2 1\n1 2", "1\n2");
await testSS("2 4 2\n1 2\n3 4", "1\n2");
await testSS("2 4 1\n3 4", "3\n4");
await testSS("2 4 3\n1 2\n1 3\n2 3", "1\n2");
await testSS("2 4 3\n1 2\n1 3\n1 4", "1\n2");

await testSS(gd.generate_false(), "-1")
let data = gd.generate_true();
await testSS(data.in, data.out);
