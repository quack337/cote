N=0n;for(i=1;N<=1e18;++i)N=N*2n+1n;
F=(n,k)=>{
 for(v=0;;){
  n=(n-1n)/2n;
  if(!k||k==n)return v?1:0; 
  if(k>=n){v=!v;k=n-k+n}}} 
K=(require('fs').readFileSync(0)+'').split('\n').map(e=>BigInt(e));
X=[];T=K[0];
for(t=1;t<=T;++t)X.push('Case #'+t+': '+F(N,K[t]-1n));
console.log(X.join('\n'))