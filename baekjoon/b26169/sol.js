let IN=require('fs').readFileSync(0).toString().trim().split(/[\r\n]+/),
A=IN.slice(0,5).map(s=>s.split(' ').map(e=>+e)),
[r,c]=IN[5].split(' ').map(e=>+e), D=[[-1,0],[0,1],[1,0],[0,-1]],
V=A.map(_=>[]);

V[r][c]=1;
DFS(r, c, 0, A[r][c]);
console.log(0);

function DFS(r0, c0, mv, eat) {
  if (eat>=2) {
    console.log(1);
    process.exit(0);
  }
  if (mv>=3) return;
  for (let [dr,dc] of D) {
    let r = r0+dr, c = c0+dc;
    if (r<0 || c<0 || r>4 || c>4 || V[r][c] || A[r][c]==-1) continue;
    V[r][c]=1;
    DFS(r, c, mv+1, eat+A[r][c]);
    V[r][c]=0;
  }
}
