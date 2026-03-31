// 통과. 그런데 느리다. 4576ms
D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];
A=Array(N+1).fill().map(_=>[]);
for(i=1;i<N;++i){
  let [a,b]=D[i].split(' ').map(e=>+e);
  A[a].push(b);
  A[b].push(a);
}
P=Array(N+1),L=Array(N+1);
DFS(1, -1, 0);
function DFS(n, p, l) {
  if(P[n]) return;
  P[n] = p; L[n] = l;
  for(let b of A[n]) DFS(b, n, l + 1);
}
M=D[N];X=[];
for(i=1;i<=M;++i){
  let [a,b]=D[N+i].split(' ').map(e=>+e);
  while (L[a] != L[b])
    if (L[a] > L[b]) a = P[a]; else b = P[b];
  while (a != b) {
    a = P[a]; b = P[b];
  }
  X.push(a);
}
console.log(X.join('\n'));
