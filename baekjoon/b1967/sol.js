let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt();
let neighbors = Array(N).fill().map(() => []);
for (let i = 0; i < N-1; ++i) {
  let a = getInt() - 1, b = getInt() - 1, cost = getInt();
  neighbors[a].push([b, cost]);
  neighbors[b].push([a, cost]);
}
let visited = [], maxDepth = 0, maxDepthNode = 0;
DFS(0, 0);
visited = []; maxDepth = 0;
DFS(maxDepthNode, 0);
console.log(maxDepth);

function DFS(node, depth) {
  if (visited[node]) return;
  visited[node] = true;
  if (depth > maxDepth)
    [maxDepth, maxDepthNode] = [depth, node];
  for (let [neighbor, cost] of neighbors[node])
    DFS(neighbor, depth + cost);
}
