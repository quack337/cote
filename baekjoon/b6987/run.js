let fs = require('fs');
let util = require('util');
let exec = util.promisify(require('child_process').exec);
let generate = require('./generate_data').generate;

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


async function testSS(inputString, outputString) {
  fs.writeFileSync("data_temp", inputString);
  await testFS("data_temp", outputString);
}

testFS("data1", "1 1 0 0")
testFS("data2", "1 1 1 1")
testFS("data3", "0 0 0 0")
testFS("data4", "0 0 0 0")
testFS("data5", "0 0 0 0")
testFS("data6", "1 1 1 1")
testFS("data7", "0 0 0 0")
testFS("data8", "1 1 1 1")
testFS("data9", "0 0 0 0")
