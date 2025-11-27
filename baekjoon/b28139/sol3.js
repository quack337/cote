A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=A.shift(0)[0];
X=0;
for(let i=1;i<N;++i)
for(let j=0;j<i;++j)X+=Math.sqrt((A[i][0]-A[j][0])**2 + (A[i][1]-A[j][1])**2);
console.log(X*2/N)