D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,M]=D[0];
B=D[1];
A=Array(N).fill(0);
M+=2;
for (let i=2; i<M; ++i){
 let d=D[i]; A[d[0]-1]+=d[1];
}
P=Array(N);
P[0]=0;
BT=e=>{
 if (P[e]!=undefined) return P[e];
 return P[e]=A[e]+BT(B[e]-1);
}
for (let e=1; e<N; ++e) BT(e);
console.log(P.join(' '));