import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

async function getStdout(cmd) {
  let { stdout } = await exec(cmd);
  return stdout
}

async function testCCS(cmd1, cmd2, inputString) {
  fs.writeFileSync("data_temp", inputString);
  let out1 = (await exec(cmd1 + " < data_temp")).stdout.trim();
  let out2 = (await exec(cmd2 + " < data_temp")).stdout.trim()
  let label = "run with " + inputString;
  if (out1 == out2)
    console.log(label, true);
  else {
    console.log(label, false);
    process.exit(1);
  }
}

let cmd1 = "node sol2.js"
let cmd2 = "node sol2n.js"

for (let n=999000; n<=1000000; ++n) {
  await testCCS(cmd1, cmd2, n.toString())
}
