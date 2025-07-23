let DP = [];

function 완전탐색(n) {
  if (DP[n]) return DP[n];
  if (n == 0) return DP[n] = 1;
  let r1 = 0, r2 = 0, r3 = 0; 
  if (n >= 1) r1 = 완전탐색(n - 1); 
  if (n >= 2) r2 = 완전탐색(n - 2);
  if (n >= 3) r3 = 완전탐색(n - 3);
  return DP[n] = r1 + r2 + r3;
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let T = parseInt(input[0]);
let result = [];
for (let t = 0; t < T; ++t) {
  let r = 완전탐색(input[t+1]);
  result.push(r);
}
console.log(result.join('\n'));
