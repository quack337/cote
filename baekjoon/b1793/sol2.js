D=(require('fs').readFileSync(0)+'').trim().split('\n').map(e=>+e);
M=Array(251);
M[0]=M[1]=1n;
for(let i=2;i<=251;++i)M[i]=M[i-1]*2n+(i%2?-1n:1n);
X='';
for(let i=0;i<D.length;++i)X+=M[D[i]]+'\n';
console.log(X);