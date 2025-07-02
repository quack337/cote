let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), R = getInt();
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = getInt();
let selected = [], answer = [];
A.sort((a, b) => a - b);
DFS();
console.log(answer.join('\n'));

function DFS() {
  if (selected.length == R) {
    answer.push(selected.join(' '));
    return;
  }
  for (let i = 0; i < N; ++i)
    if (!selected.includes(A[i])) {
      selected.push(A[i]);
      DFS();
      selected.pop();
    }
}
