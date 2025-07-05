let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), in_idx = 0;
let getStr = () => input[in_idx++];
let A = [], ROW = 5, COL = 5;
for (let r = 0; r < ROW; ++r)
  A[r] = getStr().split('');
let selected = [], N = ROW * COL, R = 7, answer = 0;
DFS(0, N-R);
console.log(answer);

function DFS(from, to) {
  if (selected.length == R) {
    if (isValid()) ++answer;
    return;
  }
  for (let i = from; i <= to; ++i)
    if (!selected.includes(i)) {
      selected.push(i);
      DFS(i + 1, to + 1);
      selected.pop();
    }
}

function isValid() {
  let count = 0;
  let B = A.map(() => []);
  for (let i of selected) {
    let c = i % COL, r = (i - c) / COL;
    B[r][c] = 1;
    if (A[r][c] == 'S') ++count;
  }
  if (count < 4) return false;

  let i = selected[0], c = i % COL, r = (i - c) / COL;
  count = 0;
  DFS(r, c);
  return count == 7;

  function DFS(r, c) {
    if (B[r][c] != 1) return;
    B[r][c] = 0;
    ++count;
    if (r > 0) DFS(r-1, c);
    if (c > 0) DFS(r, c-1);
    if (r < ROW-1) DFS(r+1, c);
    if (c < COL-1) DFS(r, c+1);
  }
}
