const fs = require('fs');
const input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
const A = [];
for (let i = 0; i < 100; ++i)
  A[i] = [];
const N = parseInt(input[index++]);
for (let i = 0; i < N; ++i) {
  let x = parseInt(input[index++]);
  let y = parseInt(input[index++]);
  for (let dx = 0; dx < 10; ++dx)
    for (let dy = 0; dy < 10; ++dy)
        A[x + dx][y + dy] = true;
}
let count = 0;
for (let x = 0; x < 100; ++x)
  for (let y = 0; y < 100; ++y)
    if (A[x][y]) ++count;
console.log(count);
