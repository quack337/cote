let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), R = getInt();
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = getInt();
let selected = [], answer = [];
A.sort((a, b) => a - b);
DFS(0, N-R);
console.log(answer.join('\n'));

function DFS(from, to) {
  if (selected.length == R) {
    answer.push(selected.map(i => A[i]).join(' '));
    return;
  }
  for (let i = from; i < N; ++i) {
    selected.push(i);
    DFS(i + 1, to + 1);
    selected.pop();
  }
}
