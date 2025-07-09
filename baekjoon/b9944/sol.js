let IN = require('fs').readFileSync(0).toString().trim().split(/[\r\n]+/), idx=0;
let RN, CN, ALL, A, V, MV, OUT=[];
let DD = [[-1,0],[0,1],[1,0],[0,-1]];
let empty = (r,c) => (r>=0 && c>=0 && r<RN && c<CN) && !V[r][c] && A[r][c]=='.';
for (let t=1;; ++t) {
  [RN, CN] = IN[idx++].split(' ').map(e=>+e);
  A = IN.slice(idx, idx+=RN).map(s => s.split(''));
  MV=Infinity; ALL=A.reduce((r1,e1) => e1.reduce((r2,e2) => r2 + (e2=='.'? 1 : 0), r1), 0);
  for (let r=0; r < RN; ++r)
    for (let c=0; c < CN; ++c)
      if (A[r][c] == '.') {
        V = A.map(_=>[]);
        V[r][c] = true;
        DFS(r, c, 0, 1);
      }
  if (RN==1 && CN==1 && A[0][0]=='.') MV = 1;
  OUT.push('Case ' + t + ': ' + (MV==Infinity ? -1 : MV));
  if (idx >= IN.length) break;
}
console.log(OUT.join('\n'));

function DFS(r, c, mv, vcnt) {
  if (vcnt == ALL) {
    if (mv < MV) MV = mv;
    return;
  }
  for (let [dr, dc] of DD) {
    let r1 = r+dr, c1 = c+dc;
    if (!empty(r1,c1)) continue;
    for (;;) {
      V[r1][c1] = true; ++vcnt;
      r1 = r1+dr; c1 = c1+dc;
      if (!empty(r1, c1)) break;
    }
    r1 -= dr; c1 -= dc;
    DFS(r1, c1, mv+1, vcnt);
    for (;;) {
      V[r1][c1] = false; --vcnt;
      r1 = r1-dr, c1 = c1-dc;
      if (r1==r && c1==c) break;
    }
  }
}