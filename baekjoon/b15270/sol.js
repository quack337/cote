nums=s=>s.split(' ').map(e=>+e)
D=(require('fs').readFileSync(0)+'').split('\n')
let [N,M]=nums(D[0])
A=D.slice(1,M+1).map(s=>nums(s))
V=[]
X=0
BT=(n,x)=>{
  if(n==A.length) {if(x>X) X=x; return}
  let [a,b]=A[n]
  if(!V[a]&&!V[b]) {V[a]=V[b]=1; BT(n+1,x+2); V[a]=V[b]=0}
  BT(n+1,x)
}

BT(0,0)
console.log(X<N?X+1:N)