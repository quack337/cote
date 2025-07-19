const INF = 9000;
let DP = [];

function 완전탐색(n) {
  if (DP[n]) return DP[n];
  if (n == 5 || n == 3) return DP[n] = 1;
  let r1 = INF, r2 = INF;
  if (n > 5) r1 = 완전탐색(n - 5) + 1;
  if (n > 3) r2 = 완전탐색(n - 3) + 1;
  return DP[n] = (r1 < r2 ? r1 : r2);
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let n = parseInt(input[0]);
let r = 완전탐색(n);
console.log(r >= INF ? -1 : r);
