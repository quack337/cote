// 답, stack DFS
// // 강우량: 0 ~ 100
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

function DFS(rStart, cStart, 탐색할칸) {
  let stack = [], count = 0;
  stack.push([rStart, cStart]);
  while (stack.length > 0) {
    let [r, c] = stack.pop();
    if (!탐색할칸(A[r][c]) || visited[r][c]) continue;
    visited[r][c] = true;;
    ++count;
    if (r > 0) stack.push([r-1, c]);
    if (c > 0) stack.push([r, c-1]);
    if (r < N-1) stack.push([r+1, c]);
    if (c < N-1) stack.push([r, c+1]);
  }
  return count;
}