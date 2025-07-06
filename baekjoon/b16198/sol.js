let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => +data[idx++];
let N = getInt();
let A = [], selected = [], 답 = 0;
for (let i = 0; i < N; ++i)
  A[i] = getInt();
DFS();
console.log(답);

function DFS() {
  if (selected.length == N-2) {
    답 = Math.max(답, calc());
    return;
  }
  for (let i = 1; i <= N-2; ++i)
    if (!selected.includes(i)) {
      selected.push(i);
      DFS();
      selected.pop();
    }
}

function calc() {
  let sum = 0, removed = [];
  for (let i of selected) {
    let left = i-1, right = i+1;
    while (removed[left]) --left;
    while (removed[right]) ++right;
    sum += A[left] * A[right];
    removed[i] = true;
  }
  return sum;
}