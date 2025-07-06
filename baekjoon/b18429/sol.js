let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => +data[idx++];
let N = getInt(), K = getInt();
let A = [], list = [], used = [], 답 = 0;
for (let i = 0; i < N; ++i)
  A[i] = getInt();
DFS();
console.log(답);

function DFS() {
  if (list.length == N) {
    let w = 0;
    for (let i of list) {
      w += A[i] - K;
      if (w < 0) return;
    }
    ++답;
    return;
  }
  for (let i = 0; i < N; ++i)
    if (!used[i]) {
      list.push(i); used[i] = true;
      DFS();
      list.pop(); used[i] = false;
    }
}