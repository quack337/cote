let N=+(require('fs').readFileSync(0)+'').trim();
let ALL=(1<<10)-1, MOD=1_000_000_000;
let M=Array(N).fill().map(_=>Array(10).fill().map(_=>[]));
let r = 0;
for (let i=1; i<=9; ++i)
  r = (r + DFS(1, i, 1<<i)) % MOD;
console.log(r);

function DFS(n, prev, bit) {
  if (n==N) return bit==ALL ? 1:0;
  if (M[n][prev][bit]!=undefined) return M[n][prev][bit];
  let r = 0;
  if (prev > 0) r = (r + DFS(n+1, prev-1, bit|(1<<prev-1))) % MOD;
  if (prev < 9) r = (r + DFS(n+1, prev+1, bit|(1<<prev+1))) % MOD;
  return M[n][prev][bit]=r;
}
