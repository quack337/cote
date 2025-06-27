// 답, 재귀 DFS
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let ROW = getInt(), COL = ROW, size;
let A = [];
for (let r = 0; r < ROW; ++r)
  A[r] = getStr().split('');
let 집 = '1';
let sizes = 연결그래프크기();
sizes.sort((a, b) => a - b);
let answer = [sizes.length, ...sizes];
console.log(answer.join('\n'));

function 연결그래프크기() {
  let sizes = [];
  visited = Array(ROW).fill().map(() => []);
  for (let r = 0; r < ROW; ++r)
    for (let c  = 0; c < COL; ++c)
      if (!visited[r][c] && A[r][c] == 집) {
        size = 0;
        DFS(r, c);
        sizes.push(size);
      }
  return sizes;
}

function DFS(r, c) {
  if (visited[r][c] || A[r][c] != 집) return;
  visited[r][c] = true;
  ++size;
  if (r > 0) DFS(r-1, c);
  if (c > 0) DFS(r, c-1);
  if (r < ROW-1) DFS(r+1, c);
  if (c < COL-1) DFS(r, c+1);
}
