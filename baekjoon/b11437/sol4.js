// cache 활용 시간 초과
D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];
A=Array(N+1).fill().map(_=>[]);
for(i=1;i<N;++i){
  let [a,b]=D[i].split(' ');
  a=+a;b=+b;
  A[a].push(b);
  A[b].push(a);
}
P=Array(N+1),L=Array(N+1);
S=[];
S.push([1, -1, 0]);
while (S.length > 0) {
  let [n, p, l] = S.pop();
  if(P[n]) continue;
  P[n] = p; L[n] = l;
  for(let b of A[n]) S.push([b, n, l + 1]);
}
M=D[N]; X=[]; cache = {};
for(i=1;i<=M;++i){
  let [a,b]=D[N+i].split(' ');
  a=+a;b=+b;
  while (L[a] != L[b])
    if (L[a] > L[b]) a = P[a]; else b = P[b];
  S = [];
  while (a != b) {
    k = a + " " + b;
    if (cache[k]) { a = cache[k]; break; }
    S.push();
    a = P[a]; b = P[b];
  }
  X.push(a);
  while (S.length > 0) {
    let k = S.pop();
    cache[k] = a;
  }
}
console.log(X.join('\n'));
