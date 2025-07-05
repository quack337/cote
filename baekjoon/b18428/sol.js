let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getStr = () => data[idx++], getInt = () => +data[idx++];
let ROW = getInt(), COL = ROW;
let A = Array(ROW).fill().map(() => []), blanks = [], students = [];
for (let r = 0; r < ROW; ++r)
  for (let c = 0; c < COL; ++c)
    switch (A[r][c] = getStr()) {
    case 'X': blanks.push([r, c]); break;
    case 'S': students.push([r, c]); break;
    }
const DR = [-1,0,1,0], DC = [0,1,0,-1];
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
    selected.push(i);
    DFS(from + 1, to + 1, depth + 1);
    selected.pop();
  }
}

function set(ch) {
  for (let i of selected) {
    let [r, c] = blanks[i];
    A[r][c] = ch;
  }
}

function ok() {
  for (let [r, c] of students)
    if (!studentOk(r, c))
      return false;
  return true;
}

function studentOk(r, c) {
  for (let d = 0; d < 4; ++d)
    if (findT(r, c, d))
      return false;
  return true;
}

function findT(r, c, i) {
  for (;;) {
    r += DR[i]; c += DC[i];
    if (r < 0 || c < 0 || r >= ROW || c >= COL) return false;
    if (A[r][c] == 'O') return false;
    if (A[r][c] == 'T') return true;
  }
}