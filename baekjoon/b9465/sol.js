D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
max=Math.max
T=+D[0]
X=[]
for(t=0,d=1;t<T;++t){
 N=+D[d++],A=D[d++],B=D[d++]
 M=Array(N).fill().map(_=>[])
 M[0]=[0,A[0],B[0]]
 for(i=1;i<N;++i){[a,b,c]=M[i-1];M[i]=[max(a,b,c),max(a,c)+A[i],max(a,b)+B[i]]}
 X.push(max(...M[N-1]))
}
console.log(X.join('\n'))