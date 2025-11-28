D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];T=+D[2];
A=D[1].split(' ').map(e=>+e);
X=0;
for(let i=0;i<N;++i)
for(let j=0;j<N;++j)if(A[i]<A[j]&&A[i]+T>=A[j]-T)++X;
console.log(X/4)