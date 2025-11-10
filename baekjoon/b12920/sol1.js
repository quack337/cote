A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,W]=A.shift();
BT=(n,ww)=>{
  if(n==N)return 0;
  let [w,p,c] = A[n], x=0;
  for (let i=0;i<=c&&w*i<=ww;++i){
    let t = BT(n+1,ww-w*i) + p*i;
    if (t > x) x = t;
  }
  return x;
}
console.log(BT(0,W))