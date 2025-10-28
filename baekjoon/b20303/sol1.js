// 배낭문제 응용. 시간초과
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
let P=Array(N).fill().map(_=>[]);
console.log(DFS2(0,K-1));

function DFS1(n){
  V[n]=1;++b;c+=A[n];
  let f=F[n];
  for(let i=0;i<f.length;++i){
    let b=f[i];
    if(!V[b]) DFS1(b);
  }
}
function DFS2(n,k){
  if(n==B.length)return 0;
  if(P[n][k]!=undefined)return P[n][k];
  return P[n][k]=Math.max(DFS2(n+1,k), k>=B[n] ? DFS2(n+1,k-B[n])+C[n] : 0);
}