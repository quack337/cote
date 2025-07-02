let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), R = N;
let selected = [], answer = Number.MAX_VALUE;
let A = Array(N).fill().map(() => []);
for (let r = 0; r < N; ++r)
  for (let c = 0; c < N; ++c)
    A[r][c] = getInt();
DFS();
console.log(answer);

function DFS() {
  if (selected.length == R) {
    let costSum = 0;
    selected.push(selected[0]);
    for (let i = 0; i < N; ++i) {
      let cost = A[selected[i]][selected[i+1]];
      if (cost == 0) { costSum = Number.MAX_VALUE; break; }
      costSum += cost;
    }
    selected.pop();
    if (costSum < answer) answer = costSum;
    return;
  }
  for (let i = 0; i < N; ++i)
    if (!selected.includes(i)) {
      selected.push(i);
      DFS();
      selected.pop();
    }
}