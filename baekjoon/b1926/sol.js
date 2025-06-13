let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let ROW = getInt(), COL = getInt();
let A = Array(ROW).fill().map(() => []);
for (let r = 0; r < ROW; ++r)
  for (let c = 0; c < COL; ++c)
    A[r][c] = getInt();
let count = 0, size = 0;
let visited = Array(ROW).fill().map(() => []);
for (let r = 0; r < ROW; ++r)
  for (let c = 0; c < COL; ++c)
    if (!visited[r][c] && A[r][c] == 1) {
      let s = DFS(r, c);
      if (s > size) size = s;
      ++count;
    }
console.log(count + '\n' + size);

function DFS(rStart, cStart) {
  let size = 0;
  let stack = [];
  stack.push([rStart, cStart]);
  while (stack.length > 0) {
    let [r, c] = stack.pop();
    if (visited[r][c] || A[r][c] == 0) continue;
    visited[r][c] = true;
    ++size;
    if (r > 0) stack.push([r-1, c]);
    if (c > 0) stack.push([r, c-1]);
    if (r < ROW-1) stack.push([r+1, c]);
    if (c < COL-1) stack.push([r, c+1]);
  }
  return size;
}
