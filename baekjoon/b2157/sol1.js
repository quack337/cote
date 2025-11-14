D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,M,K]=D[0];
A=Array(N).fill().map(_=>[]);
for(let i=1;i<=K;++i){
  let [a,b,c]=D[i];--a;--b;
  A[a].push([b,c]);
}
P=Array(N).fill().map(_=>[]);
BT=(n,m)=>{
  if(n==N-1)return 0;
  if(m==1)return -Infinity;
    if(P[n][m]!=undefined)return P[n][m];
  let a=A[n],x=-Infinity;
  for(let i=0;i<a.length;++i){
    let [b,c]=a[i];
    if(b>n){let t=BT(b,m-1)+c; if(t>x)x=t;}
  }
  return P[n][m]=x;
}
console.log(BT(0,M))