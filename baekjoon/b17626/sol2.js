let N = +require('fs').readFileSync(0).toString();
let M = [], MIN = Infinity;
console.log(DFS(N,0));

function DFS(n,depth) {
  if (n==0) return 0;
  if (depth >= MIN) return Infinity;
  if (M[n] != undefined) return M[n];
  let e = Math.floor(Math.sqrt(n));
  let r = Infinity;
  for (let i=e; i>0; --i) {
    r = Math.min(r, DFS(n - i*i, depth+1) + 1);
    if (depth==0) MIN = Math.min(MIN, r);
  }
  return M[n] = r;
}