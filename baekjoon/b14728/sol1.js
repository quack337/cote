A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,T]=A.shift();
M=Array(N).fill().map(_=>[0]);
BT=(n,t)=>{
  if(n==N)return 0;
  if(M[n][t]!=undefined)return M[n][t];
  let[u,v]=A[n];
  return M[n][t]=Math.max(BT(n+1,t),t<u?0:v+BT(n+1,t-u));
}
console.log(BT(0,T));