A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
N=A.shift()[0]
M=[]
M[N]=0
for(n=N-1;n>=0;--n){let[t,p]=A[n];M[n]=Math.max(n+t>N?0:M[n+t]+p,M[n+1])}
console.log(M[0])