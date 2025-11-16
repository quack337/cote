D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.trim().split(' ').map(e=>+e));
M=D[0][0];
A=D[1];
R=D[2][0];
N=A.reduce((a,b)=>a+b);
C=Array(N+1).fill().map((_,i)=>Array(i+1).fill(1n));
for(let n=2;n<=N;++n)
for(let r=1;r<n;++r)C[n][r]=C[n-1][r-1]+C[n-1][r];
nCr=(n,r)=>r>n?0n:C[n][r];
X= A.map(n=>nCr(n,R)).reduce((a,b)=>a+b) * BigInt(1e12) / nCr(N,R);
console.log(Number(X)/1e12)