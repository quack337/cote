const INF = 9_000_000;
let DP = [];

function 완전탐색(n) {
  if (DP[n]) return DP[n];
  if (n == 1) return DP[n] = 0;
  let r1 = INF, r2 = INF, r3 = INF;
  if (n % 3 == 0) r1 = 완전탐색(n / 3) + 1;
  if (n % 2 == 0) r2 = 완전탐색(n / 2) + 1;
  r3 = 완전탐색(n - 1) + 1;
  return DP[n] = Math.min(r1, r2, r3);
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let n = parseInt(input[0]);
let r = 완전탐색(n);
console.log(r >= INF ? -1 : r);
