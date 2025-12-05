import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);

let command = "node sol3.js"
let inputCount = 1;

async function testF(inputFile, output, off=1e-9) {
  let cmd = command + " < " + inputFile
  let { stdout, stderr } = await exec(cmd);
  let label = inputFile != "data_temp" ? inputFile : "input" + inputCount++;
  let ok = (typeof output == "string") ? (stdout.trim() == output) :
    (typeof output == "number") ? (Math.abs(Number(stdout.trim()) - output) <= off) :
    (typeof output == "object") ? stdout.trim().split(/\s+/)
                                    .reduce((a,e,i)=>a && +e-output[i]<=off, true) :
    false;
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

let X=[
["222", "221", "212", "211", "122", "121", "112", "111"],
["223", "224", "213", "214", "123", "124", "113", "114"],
["232", "231", "242", "241", "132", "131", "142", "141"],
["233", "234", "243", "244", "133", "134", "143", "144"],
["322", "321", "312", "311", "422", "421", "412", "411"],
["323", "324", "313", "314", "423", "424", "413", "414"],
["332", "331", "342", "341", "432", "431", "442", "441"],
["333", "334", "343", "344", "433", "434", "443", "444"]];

let s="3 222"
for(let r=0;r<8;++r)
for(let c=0;c<8;++c){
  let input = s+"\n"+c+" "+(-r);
  await testS(input, X[r][c]);
}
await testS("3 222\n0 1", "-1");
await testS("3 222\n0 -8", "-1");
await testS("3 222\n-1 0", "-1");
await testS("3 222\n8 0", "-1");

await testS("1 1\n0 0", "1");
await testS("1 1\n-1 0", "2");
await testS("1 1\n0 -1", "4");
await testS("1 1\n-1 -1", "3");

await testS("1 1\n0 1", "-1");
await testS("1 1\n1 0", "-1");

await testS("50 11111111111111111111111111111111111111111111111111\n0 0", "11111111111111111111111111111111111111111111111111");
await testS("50 11111111111111111111111111111111111111111111111111\n-1 0", "11111111111111111111111111111111111111111111111112");
await testS("50 11111111111111111111111111111111111111111111111111\n0 -1", "11111111111111111111111111111111111111111111111114");
await testS("50 11111111111111111111111111111111111111111111111111\n-1 -1", "11111111111111111111111111111111111111111111111113");
