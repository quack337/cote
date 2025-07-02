let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let K = getInt(), R = K+1;
let selected = [], min = Array(R).fill(9).join(''), max = Array(R).fill(0).join('');
let A = [];
for (let i = 0; i < K; ++i)
    A[i] = getStr();
DFS();
console.log(max + "\n" + min);

function DFS() {
  if (selected.length == R && isValid()) {
    let s = selected.join('');
    if (s.localeCompare(max) > 0) max = s;
    if (s.localeCompare(min) < 0) min = s;
    return;
  }
  for (let i = 0; i <= 9; ++i)
    if (!selected.includes(i)) {
      selected.push(i);
      DFS();
      selected.pop();
    }
}

function isValid() {
  for (let i = 0; i < K; ++i) {
    if (A[i] == '<' && selected[i] > selected[i+1]) return false;
    if (A[i] == '>' && selected[i] < selected[i+1]) return false;
  }
  return true;
}
