let fs = require('fs');
let util = require('util');
let exec = util.promisify(require('child_process').exec);
let gd = require('./generate_data');

let command = "node sol.js"

async function testFS(inputFile, outputString) {
  cmd = command + " < " + inputFile
  let { stdout, stderr } = await exec(cmd);
  if (stdout.trim() == outputString)
    console.log(inputFile, true);
  else {
    console.log(inputFile, false, stdout);
    process.exit(1);
  }
}

(async function() {
  let N = 100;
  for (let i = 0; i < N; ++i) {
    let fname = "data1_" + i;
    gd.generate1(fname);
    await testFS(fname, "1 1 1 1");
  }
  for (let i = 0; i < N; ++i) {
    let fname = "data2_" + i;
    gd.generate1(fname);
    await testFS(fname, "0 0 0 0");
  }
})();
