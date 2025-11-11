A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=A.shift()[0];
A.sort((a,b)=>b[0]*b[1]-a[0]*a[1]);
for(let i=0;i<N;++i){let[w,h]=A[i];if(w<h)A[i]=[h,w];}
M=Array(1001).fill().map(_=>[]);
BT=(n,W,H)=>{
  if(n==N)return 0;
  if(M[W][H]!=undefined)return M[W][H];
  let [w,h]=A[n];
  return M[W][H]=Math.max(BT(n+1,W,H), w<=W&&h<=H ? BT(n+1,w,h)+1 : 0); 
}
console.log(BT(0,1000,1000))