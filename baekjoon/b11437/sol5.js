// 1752
D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];
A=Array(N+1).fill().map(_=>[]);
for(let i=1;i<N;++i){
  [a,b]=D[i].split(' ');a=+a;b=+b;
  A[a].push(b);
  A[b].push(a);
}
P=Array(N+1),L=Array(N+1);
S=[[1, -1, 0]];
while (S.length > 0) {
  [n,p,l] = S.pop();
  if(P[n])continue;
  P[n]=p; L[n]=l;
  An=A[n];
  for(let i=0; i<An.length; ++i) S.push([An[i], n, l+1]);
}
M=D[N]; X=[];
for(let i=1;i<=M;++i){
  let [a,b]=D[N+i].split(' ');a=+a;b=+b;
  while (L[a] > L[b]) a=P[a];
  while (L[a] < L[b]) b=P[b];
  while (a != b) {a=P[a]; b=P[b]}
  X.push(a);
}
console.log(X.join('\n'))