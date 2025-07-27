D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
let[N,M]=D[0]
A=D.slice(1,N+1)
Q=D.slice(N+1)
for(i=1;i<N;++i){A[i][0]+=A[i-1][0];A[0][i]+=A[0][i-1]}
for(r=1;r<N;++r)for(c=1;c<N;++c)A[r][c]+=A[r-1][c]+A[r][c-1]-A[r-1][c-1]
X=[]
for(i=0;i<M;++i){
 [r1,c1,r2,c2]=Q[i]
 --r1;--c1;--r2;--c2
 x=A[r2][c2]
 if(c1)x-=A[r2][c1-1]
 if(r1)x-=A[r1-1][c2]
 if(c1&&r1)x+=A[r1-1][c1-1]
 X.push(x)
}
console.log(X.join('\n'))