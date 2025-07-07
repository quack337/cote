let fs = require('fs');
let util = require('util');
let exec = util.promisify(require('child_process').exec);

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
  testFS("data_temp", outputString);
}

testFS("data1", "134\n2 4 6")
testFS("data2", "78\n2 4 6")
testFS("data3", "2\n1 2")
testFS("data4", "1\n1")