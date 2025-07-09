let _D = require('fs').readFileSync(0).toString().split('\n'),
 [RN,CN]=_D[0].split(' ').map(e=>+e),
 A=_D.slice(1).map(s=>s.split(' ').map(e=>+e));
let BLK=[[[0,0,2],[0,1,1],[1,0,1]], [[0,0,1],[0,1,2],[1,1,1]],
 [[0,0,1],[1,0,2],[1,1,1]], [[0,0,1],[1,-1,1],[1,0,2]]];
let V=A.map(e=>[]), 답=0;
DFS(0,0,0);
console.log(답);

function DFS(r, c, pt) {
  if (c >= CN) {
    c = 0;
    if (++r >= RN) {
      if (pt > 답) 답 = pt;
      return;
    }
  }
  if (!V[r][c])
    for (let bk=0; bk < 4; ++bk) {
      let p = point(r, c, bk);
      if (p >= 0) {
        mark(r, c, bk, true);
        DFS(r, c+1, pt+p);
        mark(r, c, bk, false);
      }
    }
  DFS(r, c+1, pt);
}

function point(r, c, bk) {
  let pt = 0;
  for (let [dr, dc, w] of BLK[bk]) {
    let r1 = r+dr, c1 = c+dc;
    if (r1<0 || c1<0 || r1>=RN || c1>=CN) return -1;
    if (V[r1][c1]) return -1;
    pt += A[r1][c1] * w;
  }
  return pt;
}

function mark(r, c, bk, val) {
  for (let [dr, dc] of BLK[bk]) {
    V[r+dr][c+dc] = val;
  }
}
