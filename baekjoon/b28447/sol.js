let nums= s=>s.split(' ').map(e=>+e),
IN=require('fs').readFileSync(0).toString().split('\n'),
[N,R]=nums(IN[0]), A=IN.slice(1).map(e=>nums(e)),
S=Array(R), X=-Infinity;
DFS(0,N-R,0)
console.log(X)

function DFS(from,to,n) {
  if (n==R) {
    let x=0;
    for (let i=0; i<R-1; ++i)
      for (let j=i+1; j<R; ++j)
        x += A[S[i]][S[j]]
    if (x>X) X=x
    return
  }
  for (let i=from; i<=to; ++i) {
    S[n]=i; DFS(i+1,to+1,n+1)
  }
}