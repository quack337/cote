let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), parents = [];
for (let child = 0; child < N; ++child)
  parents[child] = getInt();
let X = getInt();
let children = Array(N).fill().map(() => []), root;
for (let child = 0; child < N; ++child) {
  let parent = parents[child];
  if (parent == -1) root = child;
  else children[parent].push(child);
}
if (X == root) { console.log(0); return; }
let removedNodes = new Set();
DFS_remove(X);
let leafCount = 0;
for (let i = 0; i < N; ++i) {
  if (removedNodes.has(i)) continue;
  if (children[i].filter(n => !removedNodes.has(n)).length == 0)
    ++leafCount;
}
console.log(leafCount);

function DFS_remove(node) {
  removedNodes.add(node);
  for (let child of children[node])
    DFS_remove(child);
}
