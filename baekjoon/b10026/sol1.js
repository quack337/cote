// 답, 재귀 DFS
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt();
let A = [], visited;
for (let i = 0; i < N; ++i)
  A[i] = getStr().split('');
let 적색 = count(c => c =='R');
let 녹색 = count(c => c =='G');
let 청색 = count(c => c == 'B');
let 적녹색 = count(c => c == 'R' || c == 'G');
console.log(적색+녹색+청색, 적녹색+청색);

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
