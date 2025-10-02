D=(require('fs').readFileSync(0)+'').split('\n')
let[N,R,Q]=D[0].split(' ').map(e=>+e)
E=Array(N+1).fill().map(_=>[])
for(i=0;i<N-1;++i){
 let[a,b]=D[i+1].split(' ')
 E[a].push(b);E[b].push(a)
}
M=Array(N)
BT=(n,p)=>{
 let s=1,A=E[n]
 for(let i=0;i<A.length;++i)
  if(A[i]!=p) s+=BT(A[i],n)
 return M[n]=s
}
BT(R,-1)
X=[]
for(i=0;i<Q;++i) X.push(M[+D[N+i]])
console.log(X.join('\n'))