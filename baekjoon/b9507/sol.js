D=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
T=D[0];
M=[1n,1n,2n,4n];
M[67]=0;
for(let i=4;i<68;++i)M[i]=M[i-1]+M[i-2]+M[i-3]+M[i-4];
X='';
for(let i=1;i<=D[0];++i)X+=M[D[i]]+'\n';
console.log(X);