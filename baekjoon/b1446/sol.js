A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
let[N,D]=A[0]
M={}
BT=p=>{
 let d=D-p
 if(M[p]!=undefined)return M[p]
 for(let i=1;i<=N;++i){
  let B=A[i]
  if(B[0]>=p && B[1]<=D) d=Math.min(d,B[0]-p+B[2]+BT(B[1]))
 }
 return M[p]=d
}
console.log(BT(0))
