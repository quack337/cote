// nPn 구현
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = 3;
let selected = [];
DFS();

function DFS() {
  if (selected.length == N) {
    console.log(selected);
    return;
  }
  for (let i = 0; i < N; ++i) 
    if (!selected.includes(i)) {
      selected.push(i);
      DFS();
      selected.pop(i);
    }
}
