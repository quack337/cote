let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), R = N;
let A = [], selected = [], answer = 0;
for (let i = 0; i < N; ++i)
  A[i] = getInt();
DFS();
console.log(answer);

function DFS() {
  if (selected.length == R) {
    let sum = 0;
    for (let i = 0; i < N-1; ++i)
      sum += Math.abs(A[selected[i]] - A[selected[i+1]]);
    if (sum > answer) answer = sum;
    return;
  }
  for (let i = 0; i < N; ++i)
    if (!selected.includes(i)) {
      selected.push(i);
      DFS();
      selected.pop();
    }
}
