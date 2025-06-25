// 오답 - 혹시 stack overflow??
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), E = getInt();
let neighbors = Array(N+1).fill().map(() => []);
for (let i = 0; i < E; ++i) {
  let a = getInt(), b = getInt();
  neighbors[b].push(a);
}
let maxSize = 0, maxNodes = [], DP = [], visited;
for (let node = 1; node <= N; ++node) {
  visited = [];
  let [size] = 그래프크기(node);
  if (size > maxSize) {
    maxSize = size;
    maxNodes = [node];
  } else if (size == maxSize)
    maxNodes.push(node);
}
console.log(maxNodes.join(' '));

function 그래프크기(node) {
  if (DP[node]) return [DP[node], false];
  if (visited[node]) return [0, true];
  visited[node] = true;
  let cycle = false, size = 1;
  for (let neighbor of neighbors[node]) {
    let a = 그래프크기(neighbor);
    size += a[0];
    cycle |= a[1];
  }
  if (!cycle) DP[node] = size;
  return [size, cycle];
}