let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());

let ROW = getInt(), COL = getInt(), N = getInt();
let A = Array(ROW).fill().map(() => []);
for (let r = 0; r < ROW; ++r)
  for (let c = 0; c < COL; ++c)
    A[r][c] = getInt();
let OP = [];
for (let i = 0; i < N; ++i)
  OP[i] = {r: getInt()-1, c: getInt()-1, s: getInt()};
let selected = [], answer = Number.MAX_VALUE;
DFS();
console.log(answer);

function DFS() {
  if (selected.length == N) {
    let B = A.map(row => row.slice());
    for (let i of selected)
      rotate(B, OP[i]);
    answer = Math.min(answer, value(B));
    return;
  }
  for (let i = 0; i < N; ++i) 
    if (!selected.includes(i)) {
      selected.push(i);
      DFS();
      selected.pop(i);
    }
}

function rotate(B, op) {
  for (let s = 1; s <= op.s; ++s) {
    let r1 = op.r-s, c1 = op.c-s, r2 = op.r+s, c2 = op.c+s;
    let temp = B[r1][c1];
    for (let r = r1; r < r2; ++r) B[r][c1] = B[r+1][c1];
    for (let c = c1; c < c2; ++c) B[r2][c] = B[r2][c+1];
    for (let r = r2; r > r1; --r) B[r][c2] = B[r-1][c2];
    for (let c = c2; c > c1; --c) B[r1][c] = B[r1][c-1];
    B[r1][c1+1] = temp;
  }
}

function value(A) {
  return A.map(row => row.reduce((r, e) => r + e), 0)
          .reduce((r, e) => Math.min(r, e), Number.MAX_VALUE);
}