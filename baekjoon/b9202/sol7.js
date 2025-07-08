// 답
let D = require('fs').readFileSync(0).toString().split(/[\n\r]+/),
  WN = +D[0], WA = D.slice(1,WN+1), BN = +D[WN+1], BA = [];
for (let i=0; i<BN; ++i)
  BA[i] = D.slice(WN+2+i*4, WN+6+i*4).map(e=>e.split(''));
let trie = {map:{}, n:0, wi:-1, pt:0}, PT = [0,0,0,1,1,2,3,5,11];
for (let wi=0; wi < WN; ++wi) {
  let w = WA[wi], tr = trie;
  for (let ch of w.split('')) {
    if (!tr.map[ch]) tr.map[ch] = {map:{}, n:tr.n+1, wi:-1, pt:0};
    tr = tr.map[ch];
  }
  tr.wi = wi; tr.pt = PT[tr.n];
}
let DD=[[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]];
let B, V, WI, 답pt, 답cnt, 답w, OUT=[]
for (B of BA) {
  V = B.map(e=>[]), WI=[], 답pt=0, 답cnt=0, 답w='';
  for (let r = 0; r < 4; ++r)
    for (let c = 0; c < 4; ++c)
      DFS(r, c, trie);
  OUT.push([답pt, 답w, 답cnt].join(' '));
}
console.log(OUT.join('\n'));

function DFS(r, c, tr) {
  let ch = B[r][c];
  if (!tr.map[ch]) return;
  V[r][c] = true;
  tr = tr.map[ch];
  if (tr.wi > -1 && !WI[tr.wi]) {
    답cnt++; 답pt += tr.pt; WI[tr.wi] = true;
    let w = WA[tr.wi];
    if (w.length > 답w.length || (w.length==답w.length && w.localeCompare(답w) < 0))
      답w = w;
  }
  for (let [dr, dc] of DD) {
    let r1 = r+dr, c1 = c+dc;
    if (r1<0 || c1<0 || r1>3 || c1>3) continue;
    if (!V[r1][c1]) DFS(r1, c1, tr);
  }
  V[r][c] = false;
}