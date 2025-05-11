let C = Array(30).fill().map(() => []);
for (let n = 0; n < 30; ++n)
  C[n][n] = C[n][0] = 1;
for (let n = 2; n < 30; ++n)
  for (let r = 1; r < n; ++r)
    C[n][r] = C[n - 1][r - 1] + C[n - 1][r];

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let T = parseInt(input[index++]);
let result = []
for (let test = 0; test < T; ++test) {
  let n = parseInt(input[index++]);
  let m = parseInt(input[index++]);
  result.push(C[m][n]);
}
console.log(result.join('\n'));
