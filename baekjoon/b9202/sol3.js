// 입력 + trie + 단어점수
let D = require('fs').readFileSync(0).toString().split(/[\n\r]+/),
  WN = +D[0], WA = D.slice(1,WN+1), BN = +D[WN+1], BA = [];
for (let i=0; i<BN; ++i)
  BA[i] = D.slice(WN+2+i*4, WN+6+i*4).map(e=>e.split(''));

let trie = {map:{}, n:0, done:false, pt:0}, PT = [0,0,0,1,1,2,3,5,11];
for (let w of WA) {
  let tr = trie;
  for (let ch of w.split('')) {
    if (!tr.map[ch]) tr.map[ch] = {map:{}, n:tr.n+1, done:false, pt:0};
    tr = tr.map[ch];
  }
  tr.done = true;
  tr.pt = PT[tr.n];
}

function DFS(tr, w) {
  if (tr.done) console.log(w, tr.pt);
  for (let ch in tr.map)
    DFS(tr.map[ch], w+ch);
}

DFS(trie, '');
