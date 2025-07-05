let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let N = +data[idx++];
let A = Array(N).fill().map(() => []), blanks = [], students = [];
for (let r = 0; r < N; ++r)
  for (let c = 0; c < N; ++c) {
    let s = A[r][c] = data[idx++];
    if (s=='X') blanks.push([r, c]);
    else if (s=='S') students.push([r, c]);
  }
const DIR = [[-1,0],[0,1],[1,0],[0,-1]];
let selected = [], 답 = false;
DFS(0, blanks.length - 3, 0);
console.log(답 ? "YES" : "NO");

function DFS(from, to, depth) {
  if (selected.length == 3) {
    set('O');
    if (ok()) 답 = true;
    set('X');
    return;
  }
  for (let i = from; i <= to; ++i) {
    selected.push(blanks[i]);
    DFS(from + 1, to + 1, depth + 1);
    selected.pop();
  }
}

function set(ch) {
  for (let [r, c] of selected)
    A[r][c] = ch;
}

function ok() {
  for (let [r, c] of students)
    for (let [dr, dc] of DIR)
      if (findT(r, c, dr, dc))
        return false;
  return true;
}

function findT(r, c, dr, dc) {
  for (;;) {
    r += dr; c += dc;
    if (r < 0 || c < 0 || r >= N || c >= N) return false;
    if (A[r][c] == 'O') return false;
    if (A[r][c] == 'T') return true;
  }
}