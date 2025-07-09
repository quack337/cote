let IN = require('fs').readFileSync(0).toString().trim().split(/[\r\n ]+/).map(e=>+e),
  N=+IN[0], M=+IN[1], A=IN.slice(1), SZ=0;
A[0]=0;
DFS(0,0,1);
console.log(SZ);

function DFS(t, i, sz) {
  sz += A[i];
  if (sz > SZ) SZ = sz;
  if (t==M || i==N) return;
  DFS(t+1, i+1, sz);
  if (i < N-1) DFS(t+1, i+2, sz>>1); //0부터 N칸까지.
}