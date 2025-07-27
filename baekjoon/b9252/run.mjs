import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol_short.js"
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

await testFS('data1', 4)
await testFS('data2', 1000)
await testFS('data3', 1)
await testSS('ababcadcebdafg\nbabvebcdbefdgb', 8)
await testSS('XXXXXF\nXFXXXQ', 4)
await testSS('XFXXXQ\nXXXXXF', 4)
await testSS('A\nB', 0)
await testSS('A\nAA', 1)
await testSS('AAA\nAAAA', 3)
await testSS('ABAB\nAAB', 3)
await testSS('ABCDEF\nGHIJKA', 1)
await testSS('KKKXXXABCFFF\nABCKKKRRRFFF', 6)
await testSS('ABCKKKRRRFFF\nKKKXXXABCFFF', 6)
await testSS('ABCKKKRRRFFF\nABCRF', 5)
await testSS('ABCRF\nABCKKKRRRFFF', 5)
await testSS('HELLOWORLD\nOWOLR', 4)
await testSS('OWOLR\nHELLOWORLD', 4)
await testSS('ABCDEFG\nAJJJJJJJB', 2)
await testSS('HKAHIKHEJW\nMTHZEHCLSK', 3) // 중요한 반례
