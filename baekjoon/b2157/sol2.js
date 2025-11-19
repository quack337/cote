D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,M,K]=D[0];
A=Array(N).fill().map(_=>[]);
for(let i=1;i<=K;++i){
  let [a,b,c]=D[i];--a;--b;
  A[a][b] = Math.max(A[a][b]||0,c);
}
P=Array(N).fill().map(_=>[]);
BT=(n,m)=>{
  if(n==N-1)return 0;
  if(m==1)return -Infinity;
  if(P[n][m]!=undefined)return P[n][m];
  let a=A[n],x=-Infinity;
  for(let b=n+1;b<N;++b)
    if(a[b])x=Math.max(x,BT(b,m-1)+a[b]);
  return P[n][m]=x;
}
console.log(BT(0,M))