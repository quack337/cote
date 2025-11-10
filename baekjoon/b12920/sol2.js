A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,W]=A.shift();
P=Array(N).fill().map(_=>[]);
BT=(n,ww)=>{
  if(n==N)return 0;
  if(P[n][ww]!=undefined)return P[n][ww];
  let [w,p,c] = A[n], x=0;
  for (let i=0;i<=c&&w*i<=ww;++i){
    let t = BT(n+1,ww-w*i) + p*i;
    if (t > x) x = t;
  }
  return P[n][ww]=x;
}
console.log(BT(0,W))