let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), R = getInt();
let A = [], selected = [], answer = new Set();
for (let i = 0; i < N; ++i)
  A[i] = getStr();
DFS(0);
console.log(answer.size);

function DFS() {
  if (selected.length == R) {
    let n = parseInt(selected.map(i => A[i]).join(''));
    answer.add(n);
    return;
  }
  for (let i = 0; i < N; ++i)
    if (!selected.includes(i)) {
      selected.push(i);
      DFS();
      selected.pop();
    }
}
