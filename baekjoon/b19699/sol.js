let IN = require('fs').readFileSync(0).toString().trim().split(/[\r\n]+/),
  [N,M] = IN[0].split(' ').map(e=>+e),
  A = IN[1].split(' ').map(e=>+e), set=new Set();
DFS(0,N-M,0,0);
console.log(set.size ? [...set].sort((a,b)=>a-b).join(' ') : -1);

function DFS(from, to, m, w) {
  if (m==M) { if (prime(w)) set.add(w); return }
  for (let i=from; i<=to; ++i)
    DFS(i+1, to+1, m+1, w+A[i]);
}

function prime(n) {
  if (n==1) return 0;
  let end = Math.sqrt(n);
  for (let i=2; i <= end; ++i)
    if (n % i == 0) return 0;
  return 1;
}
