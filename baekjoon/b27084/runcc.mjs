import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

async function getStdout(cmd) {
  let { stdout } = await exec(cmd);
  return stdout
}

async function testCCF(cmd1, cmd2, file) {
  let out1 = (await exec(cmd1 + " < " + file)).stdout.trim();
  let out2 = (await exec(cmd2 + " < " + file)).stdout.trim()
  let label = "run with " + file;
  if (out1 == out2)
    console.log(label, true);
  else {
    console.log(label, false);
    process.exit(1);
  }
}

async function testCCS(cmd1, cmd2, file) {
  fs.writeFileSync("data_temp", inputString);
  testCCF("data_temp", cmd1, cmd2, file);
}

let cmd1 = "node sol1.js"
let cmd2 = "node sol2_short.js"

for (let i=1; i<20; ++i) {
  let file = "data"+i;
  if (fs.existsSync(file))
    await testCCF(cmd1, cmd2, file);
}

//await testCCF(cmd1, cmd2, "data2");
