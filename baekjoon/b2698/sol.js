D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
T=D[0][0];
BT=(n,p,k)=>{
  if(n==N) return k?0:1;
  if(M[n][p][k]!=undefined)return M[n][p][k];
  return M[n][p][k]=BT(n+1,0,k)+BT(n+1,1,k-p);
}
X=[];
for(let t=1;t<=T;++t){
  [N,K]=D[t];
  M=Array(N).fill().map(_=>[[],[]]);
  X.push(BT(0,0,K));
}
console.log(X.join('\n'))