[N,X]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
L=[1];S=[1];
for(i=1;i<=N;++i){L[i]=L[i-1]*2+3;S[i]=S[i-1]*2+1}
F=(n,x)=>!n?x>0?1:0:
x<2?0:
x<=L[n-1]?F(n-1,x-1):S[n-1]+(
 x>L[n-1]+2?1+F(n-1,x-2-L[n-1]):
 x>L[n-1]+1?1:0);
console.log(F(N,X))