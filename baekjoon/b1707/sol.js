// 답. 연결 그래프가 아닐 수 있다
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let T = getInt();
let N, E, neighbors, visited;
for (let t = 0; t < T; ++t) {
  N  = getInt(); E = getInt();
  neighbors = Array(N).fill().map(() => []);
  visited = Array(N).fill(0);
  for (let e = 0; e < E; ++e) {
    let a = getInt() - 1, b = getInt() - 1;
    if (a == b) continue;
    neighbors[a].push(b);
    neighbors[b].push(a);
  }
  console.log(solution() ? "YES" : "NO");
}

function solution() {
  for (let node = 0; node < N; ++node)
    if (visited[node] == 0)
      if (DFS(node, 1) == false) return false;
  return true;
}

function DFS(node, no) {
  if (visited[node] == no) return true;
  if (visited[node] != 0) return false;
  visited[node] = no;
  for (let neighbor of neighbors[node]) {
    let r = DFS(neighbor, -no);
    if (r == false) return false;
  }
  return true;
}
