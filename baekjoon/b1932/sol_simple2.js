let data = require('fs').readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => +data[idx++];
let N = getInt();
let A = Array(N).fill().map(() => []);
let memo = Array(N).fill().map(() => []);
for (let r=0; r < N; ++r)
  for (let c=0; c <= r; ++c)
    A[r][c] = getInt();
console.log(DFS(0,0));

function DFS(r,c) {
  if (r==N-1) return A[r][c];
  if (memo[r][c]) return memo[r][c];
  let a = DFS(r+1, c);
  let b = DFS(r+1, c+1);
  return memo[r][c] = Math.max(a, b) + A[r][c];
}