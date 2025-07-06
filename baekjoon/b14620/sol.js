let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => +data[idx++];
let N = getInt();
let A = Array(N).fill().map(() => []);
for (let r = 0; r < N; ++r)
  for (let c = 0; c < N; ++c)
  A[r][c] = getInt();
let selected = [], 답 = Infinity;
DFS(0, N*N - 3);
console.log(답);

function DFS(from, to) {
  if (selected.length == 3) {
    답 = Math.min(답, cost());
    return;
  }
  for (let i = from; i <= to; ++i) {
    selected.push(i);
    DFS(i + 1, to + 1);
    selected.pop();
  }
}

function cost() {
  const D=[[0,0],[-1,0],[0,1],[1,0],[0,-1]];
  let visited = A.map(() => []), sum = 0;
  for (let i of selected) {
    let c0 = i % N, r0 = (i-c0) / N;
    for (let [dr, dc] of D) {
      let r = r0 + dr, c = c0 + dc;
      if (r < 0 || c < 0 || r >= N || c >= N || visited[r][c])
        return Infinity;
      visited[r][c] = true;
      sum += A[r][c];
    }
  }
  return sum;
}