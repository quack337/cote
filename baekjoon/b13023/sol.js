let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), E = getInt();
let neighbors = Array(N).fill().map(() => []);
for (let i = 0; i < E; ++i) {
  let a = getInt(), b = getInt();
  neighbors[a].push(b);
  neighbors[b].push(a);
}
let visited = [];

let answer = 0;
for (let node = 0; node < N; ++node)
  if (DFS(node, 0)) { answer = 1; break; }
console.log(answer);

function DFS(node, depth) {
  if (visited[node]) return false;
  visited[node] = true;
  if (depth == 4) return true;
  for (let neighbor of neighbors[node])
    if (DFS(neighbor, depth + 1))
      return true;
  visited[node] = false;
  return false;
}