let IN=require('fs').readFileSync(0).toString().split('\n'),
N=+IN[0], nums=s=>s.split(' ').map(e=>+e),
A=[0,...nums(IN[1])],D=A.map(_=>[]),V=[],X=Infinity
for (let i=1,ii=2; i<=N; ++i) {
  let M=+IN[ii++]
  for (let j=0; j<M; ++j)
    D[i].push(nums(IN[ii++]))
}
DFS(0,0)
console.log(X)

function DFS(n,x) {
  if (x>=X) return
  if (n==N) { if (x<X) X=x; return }
  for (let i=1; i<=N; ++i)
    if (!V[i]) {
      let x1=x+Math.max(Math.max(A[i],1))
      V[i]=1; D[i].forEach(([a,d])=>A[a]-=d)
      DFS(n+1,x1)
      V[i]=0; D[i].forEach(([a,d])=>A[a]+=d)
    }
}