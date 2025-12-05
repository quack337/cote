M=(require('fs').readFileSync(0)+'')-1;
L=[,5,13];
for(i=3;L[i-1]<=M;++i)L[i]=L[i-1]+L[i-2]+1;
A=['Messi','Messi Gimossi'];
F=_=>{
 for(;i>2;--i)
  if(M>=L[i-1]){M-=L[i-1]+1;if(M<0)return' '}
  return A[i-1][M]}
X=F()
console.log(X==' '?A.join(' '):X)