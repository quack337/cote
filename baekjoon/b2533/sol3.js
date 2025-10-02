D=(require('fs').readFileSync(0)+'').split('\n')
N=+D[0]
M=Array(N*2)
E=Array(N).fill().map(_=>[])
for(i=1;i<N;++i){S=D[i].split(' '),a=S[0]-1,b=S[1]-1;E[a].push(b);E[b].push(a)}
BT=(n,p,s)=>{
 if(M[s+n])return M[s+n]
 let a=0,b=1,A=E[n]
 for(let i=0;i<A.length;++i){
  let c=A[i];if(c==p)continue
  if(s)a+=BT(c,n,0)
  b+=BT(c,n,N)
 }
 return M[s+n]=s?Math.min(a,b):b
}
console.log(BT(0,-1,1))