let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt();
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = [getInt(), getInt()];
let selected = [], answer = Number.MAX_VALUE;
DFS(0);
console.log(answer);


function DFS(index) {
  if (index == N) {
    if (selected.length > 0) {
      let 신맛 = selected.map(i => A[i]).reduce((r, e) => e[0] * r, 1);
      let 쓴맛 = selected.map(i => A[i]).reduce((r, e) => e[1] + r, 0);
      answer = Math.min(answer, Math.abs(신맛 - 쓴맛));
    }
    return;
  }
  selected.push(index);
  DFS(index + 1);
  selected.pop(index);
  DFS(index + 1);
}
