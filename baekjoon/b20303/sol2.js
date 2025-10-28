// 점화식을 그냥 생각해 내느라고 오래 걸림.
// 숏코딩이지만 다른 풀이보다 2배 느리다.
let D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let [N,M,K]=D[0];
let A=D[1];
let F=Array(N).fill().map(_=>[]);
for(let i=2;i<M+2;++i){
  let [a,b] = D[i];
  F[--a].push(--b);
  F[b].push(a);
}
let V=[], B=[], C=[], b, c;
for(let i=0;i<N;++i)
  if(!V[i]){
    b=0;c=0; DFS1(i);
    B.push(b);C.push(c);
  }
N=B.length;
let P=Array(K).fill(0);
for (let i=0; i<N; ++i){
  let b=B[i], c=C[i], Q=[...P];
  if (b<K) Q[b]=Math.max(Q[b], c);
  for (let j=0; j<K-b; ++j)
    if (P[j]) Q[j+b]=Math.max(Q[j+b], P[j]+c);
  P=Q;
}
console.log(Math.max(...P));

function DFS1(n){
  V[n]=1;++b;c+=A[n];
  let f=F[n];
  for(let i=0;i<f.length;++i){
    let b=f[i];
    if(!V[b]) DFS1(b);
  }
}
