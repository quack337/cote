nums=s=>s.split(' ').map(e=>+e)
D=require('fs').readFileSync(0).toString().split('\n')
let [N,M]=nums(D[0])
A=D.slice(1,M+1).map(s=>nums(s))
V=[]
X=0
dfs=(n,cnt)=>{
  if(n==A.length) {if (cnt>X) X=cnt; return}
  let [a,b]=A[n]
  if (!V[a]&&!V[b]) {V[a]=V[b]=1; dfs(n+1,cnt+2); V[a]=V[b]=0}
  dfs(n+1,cnt)
}

dfs(0,0)
console.log(Math.min(X+1,N))