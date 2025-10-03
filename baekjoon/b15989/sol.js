A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e)
N=Math.max(...A)
M=Array(N+1).fill(1)
for(a=2;a<=3;++a)for(i=a;i<=N;++i)M[i]+=M[i-a]
X=''
for(i=1;i<=A[0];++i)X+=M[A[i]]+'\n'
console.log(X)