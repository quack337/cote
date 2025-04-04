const fs = require('fs');
const input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
const result = new Map();
for (let i = 0; i < 10; ++i) {
  let 값 = parseInt(input[i]);
  let 나머지 = 값 % 42;
  result.set(나머지, true);
}
console.log(result.size);
