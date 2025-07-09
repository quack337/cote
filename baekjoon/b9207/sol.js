let IN = require('fs').readFileSync(0).toString().split(/[\r\n]+/);
let DD=[[-1,0],[0,1],[1,0],[0,-1]];
let T=+IN[0], A, RN=5, CN=9, P, PN, MV;
let valid = (r,c) => r>=0 && c>=0 && r<RN && c<CN;
for (let t=0, ts=1; t<T; ++t, ts+=RN) {
  A = IN.slice(ts, ts+RN).map(s=>s.split(''));
  P = [];
  for (let r=0; r < RN; ++r)
    for (let c=0; c < CN; ++c)
      if (A[r][c]=='o') {
        A[r][c] = P.length;
        P.push([r,c]);
      }
  PN = MV = Infinity;
  DFS(P.length, 0);
  console.log(PN, MV);
}

function DFS(pn, mv) {
  if (pn < PN) { PN = pn; MV = mv; }
  else if (pn == PN && mv < MV) MV = mv;
  for (let a=0; a < P.length; ++a) {
    let [r, c] = P[a];
    if (r < 0) continue;
    for (let [dr, dc] of DD) {
      let r1 = r+dr, c1 = c+dc;
      if (!valid(r1,c1)) continue;
      let b = A[r1][c1];
      if (b=='.' || b=='#') continue;
      let r2 = r1+dr, c2 = c1+dc;
      if (!valid(r2,c2) || A[r2][c2]!='.') continue;
      A[r][c] = A[r1][c1] = '.'; A[r2][c2] = a;
      P[b][0] = -1; P[a][0] = r2; P[a][1] = c2;
      DFS(pn - 1, mv + 1);
      A[r][c] = a; A[r1][c1] = b; A[r2][c2] = '.';
      P[b][0] = r1; P[a][0] = r; P[a][1] = c;
    }
  }
}