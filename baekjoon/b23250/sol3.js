[N,K]=(require('fs').readFileSync(0)+'').split(' ');
M=0n;T=N;while(T--)M=M*2n+1n;
F=(n,k,a,b,c)=>
 n==1?a+' '+c:
 k<=(M=--M/2n)?F(n-1,k,a,c,b):
 (k-=M+1n)?F(n-1,k,b,a,c):a+' '+c
console.log(F(N,BigInt(K),1,2,3))