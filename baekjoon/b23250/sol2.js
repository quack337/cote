[N,K]=(require('fs').readFileSync(0)+'').trim().split(' ');N=+N;
M=[,1n,3n];
for(i=3;i<=N;++i)M[i]=M[i-1]*2n+1n;
F=(n,k,a,b,c)=>
 n==1?a+' '+c:
 k<=M[n-1]?F(n-1,k,a,c,b):
 k==M[n-1]+1n?a+' '+c:F(n-1,k-M[n-1]-1n,b,a,c)
console.log(F(N,BigInt(K),1,2,3))