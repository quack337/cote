// trie 구현
let WA = ['AAA', 'AAB', 'AABBCC', 'AABBCCDD', 'BCD', 'C'];

let trie = {map:{}, n:0, done:false};

for (let w of WA) {
  let tr = trie;
  for (let ch of w.split('')) {
    if (!tr.map[ch]) tr.map[ch] = {map:{}, n:tr.n+1, done:false};
    tr = tr.map[ch];
  }
  tr.done = true;
}

function DFS(tr, w) {
  if (tr.done) console.log(w);
  for (let ch in tr.map)
    DFS(tr.map[ch], w+ch);
}

DFS(trie, '');