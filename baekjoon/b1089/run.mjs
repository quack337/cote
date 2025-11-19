import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol_short.js"
let inputCount = 1;

async function testF(inputFile, output) {
  let cmd = command + " < " + inputFile
  let { stdout, stderr } = await exec(cmd);
  let label = inputFile != "data_temp" ? inputFile : "input" + inputCount++;
  let ok = (typeof output == "string") ?
    (stdout.trim() == outputString) :
    (Math.abs(Number(stdout.trim()) - output) <= 1e-9);
  if (ok)
    console.log(label, true);
  else {
    console.log(label, false, stdout);
    process.exit(1);
  }
}

async function testS(inputString, output) {
  fs.writeFileSync("data_temp", inputString);
  await testF("data_temp", output);
}

await testF('data1', 8);
await testF('data2', 48.5);
await testF('data3', 49.5);
await testF('data4', -1);

const AVG = (...a) => a.reduce((a,b)=>a+b)/a.length;

await testS(`1
#..
...
...
...
...`, AVG(0,2,3,4,5,6,7,8,9));

await testS(`1
##.
...
...
...
...`, AVG(0,2,3,5,6,7,8,9));

await testS(`1
#..
#..
...
...
...`, AVG(0,4,5,6,8,9));

await testS(`1
..#
...
...
...
#..`, AVG(0,2,3,5,6,8,9));

await testS(`1
...
...
...
.#.
...`, -1);

await testS(`1
...
...
.#.
...
...`, AVG(2,3,4,5,6,8,9));

await testS(`2
.......
.......
.......
.....#.
.......`, -1);

await testS(`3
###.###.###
#.#.#.#.#.#
#.#.###.###
#.#...#...#
###.###.###`, AVG(88,89,98,99,888,889,898,899));

await testS(`9
...................................
...................................
...................................
...................................
...................................`, 999_999_999/2)