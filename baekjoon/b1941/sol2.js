// 답! 숏코딩을 위해 줄임
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), in_idx = 0;
let getStr = () => input[in_idx++];
let A = [];
for (let r = 0; r < 5; ++r)
  A[r] = getStr().split('');
let list = [], 답 = 0;
DFS(0, 18);
console.log(답);

function DFS(from, to) {
  if (list.length == 7) {
    if (valid()) ++답;
    return;
  }
  for (let i = from; i <= to; ++i)
    if (!list.includes(i)) {
      list.push(i);
      DFS(i + 1, to + 1);
      list.pop();
    }
}

function valid() {
  let count = 0, B = A.map(() => []);
  for (let i of list) {
    let c = i % 5, r = (i-c) / 5;
    B[r][c] = 1;
    if (A[r][c] == 'S') ++count;
  }
  if (count < 4) return false;

  let i = list[0], c = i % 5, r = (i-c) / 5;
  count = 0;
  DFS2(r, c);
  return count == 7;

  function DFS2(r, c) {
    if (B[r][c] != 1) return;
    B[r][c] = 0;
    ++count;
    if (r > 0) DFS2(r-1, c);
    if (c > 0) DFS2(r, c-1);
    if (r < 4) DFS2(r+1, c);
    if (c < 4) DFS2(r, c+1);
  }
}
