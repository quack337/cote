let A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let N=A[0][0],x=0,M=Array(N+1);
for(let i=1; i<=N; ++i)
  x=Math.max(x,DFS(i));
console.log(x);

function DFS(n) {
  if (M[n]) return M[n];
  let B=A[n], x=0;
  for (let i=0; i<B[1]; ++i)
    x=Math.max(x,DFS(B[i+2]));
  return M[n]=B[0]+x;
}