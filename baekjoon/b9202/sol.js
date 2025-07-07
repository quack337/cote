let D = require('fs').readFileSync(0).toString().split(/[\n\r]+/),
  WN = +D[0], WA = D.slice(1,WN+1), BN = +D[WN+1], BA = [];
for (let i=0; i<BN; ++i)
  BA[i] = D.slice(WN+2+i*4, WN+6+i*4);
let ACODE = 'a'.charCodeAt(0), trie = [{}, 0, false];

for (let w of WA) {
  let tr, [map, n, done] = tr = trie;
  for (let ch of w.split(''))
    [map, n, done] = tr = map[ch] ? map[ch] : map[ch] = [{}, n+1, false];
  tr.done = true;
}
DFS(trie, '');

function DFS(tr, w) {
  if (Object.keys(tr).length == 0)
      console.log(w);
  else
    for (let ch in tr)
      DFS(tr[ch], w+ch);
}
/// trie 구현 중 중단