let A = require('fs').readFileSync(0).toString().split(/[\r\n]+/).map(s=>s.split('')),
  PT = [[0,4],[1,1],[1,3],[1,5],[1,7],[2,2],[2,6],[3,1],[3,3],[3,5],[3,7],[4,4]],
  MAP2 = [[0,2,5,7],[7,8,9,10],[10,6,3,0],[1,2,3,4],[4,6,9,11],[11,8,5,1]],
  MAP1 = [[0,2],[3,5],[0,3],[2,3],[3,4],[0,5],[2,4],[0,1],[1,5],[1,4],[1,2],[4,5]];
let ACODE='A'.charCodeAt(0), CH='ABCDEFGHIJKL'.split('');
let V = [], B = Array(5).fill().map(_=> Array(9).fill(0));
for (let r=0; r < 5; ++r)
  for (let c=0; c < 9; ++c) {
    let ch = A[r][c];
    if (ch != '.' && ch != 'x') {
      let i = ch.charCodeAt(0) - ACODE;
      V[i] = true;
      B[r][c] = i + 1;
    }
  }
DFS(0);

function DFS(n) {
  if (n == 12) {
    console.log(A.map(e => e.join('')).join('\n'));
    process.exit(0);
  }
  let [r, c] = PT[n];
  if (A[r][c] != 'x') DFS(n+1);
  else
    for (let i = 0; i < 12; ++i)
      if (!V[i]) {
        V[i] = true; A[r][c] = CH[i]; B[r][c] = i+1;
        if (valid(n)) DFS(n+1);
        V[i] = false; A[r][c] = 'x'; B[r][c] = 0;
      }
}

function valid(n) {
  let lines = MAP1[n].map(i => MAP2[i]);
  return _valid(lines[0]) && _valid(lines[1]);
}

function _valid(line) {
  let sum = 0, zero = 0;
  for (let i of line) {
    let [r, c] = PT[i];
    if (B[r][c] == 0) ++zero;
    sum += B[r][c];
  }
  return (!zero && sum==26) || (zero && sum<26);
}