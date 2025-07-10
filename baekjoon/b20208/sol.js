let IN = require('fs').readFileSync(0).toString().split('\n'),
 [N,M,H] = IN[0].split(' ').map(e=>+e),
 A=IN.slice(1).map(s=>s.split(' ').map(e=>+e)),
 MILK=[], V=[], home, ANS=0;
let distance = (a,b) => Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
for (let r=0; r < N; ++r)
  for (let c=0; c < N; ++c) {
    if (A[r][c]==1) home = [r,c]
    else if (A[r][c]==2) MILK.push([r,c]);
  }
DFS(home,0,M);
console.log(ANS);

function DFS(pos,eat,m) {
  if (distance(pos,home)<=m && ANS < eat) ANS = eat;
  for (let i=0; i < MILK.length; ++i) {
    let dist = distance(pos, MILK[i]);
    if (V[i] || m-dist < 0) continue;
    V[i] = true;
    DFS(MILK[i], eat+1, m+H-dist);
    V[i] = false;
  }
}