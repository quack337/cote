let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), R = getInt();
let selected = [], answer = [];
DFS(1);
console.log(answer.join('\n'));

function DFS(from) {
  if (selected.length == R) {
    answer.push(selected.join(' '));
    return;
  }
  for (let i = from; i <= N; ++i) {
      selected.push(i);
      DFS(i);
      selected.pop();
    }
}
