let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), R = getInt();
let selected = [], answer = [];
DFS();
console.log(answer.join('\n'));

function DFS() {
  if (selected.length == R) {
    answer.push(selected.join(' '));
    return;
  }
  for (let i = 1; i <= N; ++i)
    if (!selected.includes(i)) {
      selected.push(i);
      DFS();
      selected.pop();
    }
}