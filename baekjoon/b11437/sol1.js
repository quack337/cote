// 시간 초과
D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];
A=Array(N+1).fill().map(_=>[]);
for(i=1;i<N;++i){
  let [a,b]=D[i].split(' ').map(e=>+e);
  A[a].push(b);
  A[b].push(a);
}
P=Array(N+1);
DFS(1, -1);
function DFS(n, p) {
  if(P[n]) return;
  P[n] = p;
  for(let b of A[n]) DFS(b, n);
}
M=D[N];X=[];
for(i=1;i<=M;++i){
  let [a,b]=D[N+i].split(' ').map(e=>+e);
  V=[];
  for(;;) {
    V[a] = a;
    a = P[a];
    if(a == -1)break;
  }
  for(;;) {
    b = P[b];
    if (V[b]) { X.push(b); break; }
  }
}
console.log(X.join('\n'));
