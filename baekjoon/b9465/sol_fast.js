D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' '))
m=Math.max
T=+D[0]
for(d=1;T--;){
N=+D[d++],A=D[d++],B=D[d++]
a=0,b=+A[0],c=+B[0]
for(i=1;i<=N;++i)[a,b,c]=[m(a,b,c),+A[i]+m(a,c),+B[i]+m(a,b)]
console.log(a)}
