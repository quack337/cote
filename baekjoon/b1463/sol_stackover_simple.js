let X = require('fs').readFileSync(0).toString().trim();
let memo = [];
console.log(DFS(X));

function DFS(x) {
  if (x==1) return 0;
  if (memo[x]) return memo[x];
  let a = Infinity, b = Infinity, c = Infinity;
  if (x % 3 == 0) a = DFS(x/3);
  if (x % 2 == 0) b = DFS(x/2);
  c = DFS(x-1);
  return memo[x] = Math.min(a,b,c) + 1;
}
