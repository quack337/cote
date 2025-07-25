// 답, stack DFS
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(); E = getInt();
let neighbors = Array(N+1).fill().map(() => []);
for (let i = 0; i < E; ++i) {
  let a = getInt(), b = getInt();
  neighbors[a].push(b);
  neighbors[b].push(a);
}
let visited = [], answer = 0;
for (let i = 1; i <= N; ++i)
  if (!visited[i]) {
    DFS(i);
    ++answer;
  }
console.log(answer);

function DFS(start) {
  let stack = [];
  stack.push([start]);
  while (stack.length > 0) {
    let node = stack.pop();
    if (visited[node]) continue;
    visited[node] = true;
    for (let neighbor of neighbors[node])
      if (!visited[neighbor])
        stack.push(neighbor);
  }
}