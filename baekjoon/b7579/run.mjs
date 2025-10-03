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

await testFS('data1', '6')
await testSS(`2 10
10 10
3 4`, '3');

await testSS(`2 20
10 10
3 4`, '7');

await testSS(`3 20
10 10 10
2 3 4`, '5');

await testSS(`3 20
10 10 10
4 3 2`, '5');

await testSS(`3 20
10 10 10
0 1 2`, '1');

await testSS(`3 30
10 10 10
0 0 0`, '0');

await testSS(`5 100
20 20 20 20 20
0 0 0 0 0`, '0');
await testSS(`7 120
20 91 92 93 94 95 100
1 2 2 2 2 2 2`, '3');
await testSS(`24 1
1 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384 32768 65536 131072 262144 524288 1048576 2097152 4194304 8388608
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1`, '1');
await testSS(`19 20169
240 2560 434 6 31 577 500 2715 2916 952 2490 258 1983 1576 3460 933 1660 2804 2584
82 77 81 0 36 6 53 78 49 82 82 33 66 8 60 0 98 91 93`, '484');
await testSS(`5 60
30 10 20 35 40
0 1 0 0 0`, '0');
await testSS(`7 120
20 91 92 93 94 95 100
1 2 2 2 2 2 2`, '3');