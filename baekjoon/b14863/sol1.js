A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,K]=A.shift();
P=Array(K+1).fill().map(_=>[]);
BT=(n,k)=>{
  if(n==N)return 0;
  if(P[n][k]!=undefined) return P[n][k];
  let [a,b,c,d]=A[n];
  let x = k>=a ? BT(n+1,k-a)+b : -Infinity;
  let y = k>=c ? BT(n+1,k-c)+d : -Infinity;
  return P[n][k]=x>y?x:y;
}
console.log(BT(0,K)+'');