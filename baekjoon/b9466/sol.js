let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let T = getInt(), A, selected;
for (let t = 0; t < T; ++t) {
  let N = getInt();
  A = [];
  for (let i = 0; i < N; ++i)
    A[i] = getInt() - 1;
  selected = [];
  for (let i = 0; i < N; ++i)
    if (!selected[i]) 팀결성(i);
  let count = 0;
  for (let i = 0; i < N; ++i)
    if (!selected[i]) ++count;
  console.log(count);
}

function 팀결성(start) {
  let visited = [];
  let node = A[start], success = false;
  while (true) {
    if (visited[node]) break;
    visited[node] = true;
    if (node == start) { success = true; break; }
    node = A[node];
  }
  if (success)
    for (let i = 0; i < visited.length; ++i)
      if (visited[i]) selected[i] = true;
}