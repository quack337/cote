// 답, 재귀 DFS
// 강우량: 0 ~ 100
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt();
let A = Array(N).fill().map(() => []), visited;
for (let r = 0; r < N; ++r)
  for (let c = 0; c < N; ++c)
    A[r][c] = getInt();
let max = 0;
for (let h = 0; h <= 100; ++h) {
  let r = count((v) => v > h);
  if (r > max) max = r;
}
console.log(max);

function count(탐색할칸) {
  visited = Array(N).fill().map(() => []);
  let count = 0;
  for (let r = 0; r < N; ++r)
    for (let c  = 0; c < N; ++c)
      if (!visited[r][c] && 탐색할칸(A[r][c])) {
        DFS(r, c, 탐색할칸);
        ++count;
      }
  return count;
}

function DFS(r, c, 탐색할칸) {
  if (!탐색할칸(A[r][c]) || visited[r][c]) return;
  visited[r][c] = true;
  if (r > 0) DFS(r-1, c, 탐색할칸);
  if (c > 0) DFS(r, c-1, 탐색할칸);
  if (r < N-1) DFS(r+1, c, 탐색할칸);
  if (c < N-1) DFS(r, c+1, 탐색할칸);
}
