import fs from 'fs';
import util from 'util';
import child_prcess from 'child_process';
let exec = util.promisify(child_prcess.exec);
import { generate } from './generate_data.js';

for (;;) {
  let s = generate();
  fs.writeFileSync("data8", s);
  let r1 = await exec("node sol.js < data8");
  let r2 = await exec("java Main.java < data8");
  let out1 = r1.stdout.trim(), out2 = r2.stdout.trim();
  if  (out1 == out2)
    console.log("ok", out1, out2);
  else {
    console.log("error", out1, out2);
    process.exit(1);
  }
}
