// 시간초과
let A = (require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
let N = A.shift(),K=A.shift();
let M = Array(K+1).fill().map(_=>Array(N+1).fill(-1));
let r = DFS(K,0);
console.log(r == Infinity ? -1 : r);

function DFS(k, from){
  if (k == 0) return 0;
  if (M[k][from]>-1) return M[k][from];
  let r = Infinity;
  for (let i = from; i < N; ++i)
    if (k >= A[i]) 
      r = Math.min(r, DFS(k-A[i], i) + 1);
  return M[k][from] = r;
}
