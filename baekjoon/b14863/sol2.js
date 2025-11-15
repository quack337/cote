// 오답..
A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,K]=A.shift();
Q=Array(K+1).fill(0);
P=Array(K+1).fill(0);
for(let i=N-1;i>=0;--i){
  for(let j=0;j<4;j+=2){
    let t=A[i][j],v=A[i][j+1];
    for(let k=K;k>=t;--k)
      Q[k]=Math.max(Q[k], P[k], P[k-t]+v);
  }
  [P,Q]=[Q,P];Q.fill(0);
}
console.log(P[K]+'')