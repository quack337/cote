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
  let out2 = (await exec(cmd2 + " < " + file)).stdout.trim();
  let label = "run with " + file;
  if (out1 == out2)
    console.log(label, true);
  else {
    console.log(label, false, out1, out2, cmd1, cmd2);
    process.exit(1);
  }
}

async function testCCS(cmd1, cmd2, inputString) {
  fs.writeFileSync("data_temp", inputString);
  await testCCF(cmd1, cmd2, "data_temp");
}

let cmd1 = "node sol1.js"
let cmd2 = "node sol4.js"

for (let i=1; i<20; ++i) {
  let file = "data"+i;
  if (fs.existsSync(file))
    await testCCF(cmd1, cmd2, file);
}

let N=20;
for(let t=0;t<10;++t){
  for(let i=1;i<=N;++i){
    let X=[]
    for(let j=0;j<N;++j){
      let x=Math.floor(Math.random()*i+1);
      X.push(x);
    }
    //console.log(X);
    await testCCS(cmd1, cmd2, N+'\n'+X.join(' '));
  }
}