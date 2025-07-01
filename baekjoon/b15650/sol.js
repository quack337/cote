let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), R = getInt();
let selected = [];
DFS(1, N-R+1);

function DFS(from, to) {
  if (selected.length == R) {
    process.stdout.write(selected.join(' ') + '\n');
    return;
  }
  for (let i = from; i <= to; ++i)
    if (!selected.includes(i)) {
      selected.push(i);
      DFS(i+1, to+1);
      selected.pop();
    }
}