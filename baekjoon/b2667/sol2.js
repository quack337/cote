// 답, stack DFS
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let ROW = getInt(), COL = ROW;
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
      if (!visited[r][c] && A[r][c] == 집)
        sizes.push(DFS(r, c));
  return sizes;
}

function DFS(rStart, cStart) {
  let stack = [], size = 0;
  stack.push([rStart, cStart]);
  while (stack.length > 0) {
    let [r, c] = stack.pop();
    if (visited[r][c] || A[r][c] != 집) continue;
    visited[r][c] = true;
    ++size;
    if (r > 0) stack.push([r-1, c]);
    if (c > 0) stack.push([r, c-1]);
    if (r < ROW-1) stack.push([r+1, c]);
    if (c < COL-1) stack.push([r, c+1]);
  }
  return size;
}