let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt();
let neighbors = Array(N+1).fill().map(() => []);
let visited = [], parents = [];
for (let i = 0; i < N-1; ++i) {
  let a = getInt(), b = getInt();
  neighbors[a].push(b);
  neighbors[b].push(a);
}
DFS(1, 0);
console.log(parents.slice(2).join('\n'));

function DFS(node, parent) {
  if (visited[node]) return;
  visited[node] = true;
  parents[node] = parent;
  for (let neighbor of neighbors[node])
    if (!visited[neighbor])
      DFS(neighbor, node);
}