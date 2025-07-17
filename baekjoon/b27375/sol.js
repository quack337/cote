nums=s=>s.split(' ').map(e=>+e)
D=require('fs').readFileSync(0).toString().split('\n')
K=nums(D[0])[1]
A=D.slice(1).map(s=>nums(s)).map(([w,s,e])=>({w,s,e,k:e-s+1})).filter(u=>u.w<5)
N=A.length
V=[[],[],[],[],[]]
X=0
empty=({w,s,e})=>{
  for (let i=s; i<=e; ++i)
    if (V[w][i]) return 0
  return 1
}
set=({w,s,e},f)=>{
  for (let i=s; i<=e; ++i)
    V[w][i]=f
}
dfs=(n,k)=>{
  if(n==N) {if(k==K) ++X; return}
  let u=A[n]
  if (empty(u)) {
    set(u,1);
    dfs(n+1,k+u.k);
    set(u,0)
  }
  dfs(n+1,k)
}

dfs(0,0)
console.log(X)