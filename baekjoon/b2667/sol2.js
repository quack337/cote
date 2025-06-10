// 답, stack DFS
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt();
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = getStr().split('');
let NOT_VISITED = '1', VISITED = 'x';
let answer = [];
for (let r = 0; r < N; ++r)
  for (let c  = 0; c < N; ++c)
    if (A[r][c] == NOT_VISITED)
      answer.push(DFS(r, c));
answer.sort((a, b) => a - b);
answer.unshift(answer.length);
console.log(answer.join('\n'));

function DFS(rStart, cStart) {
  let stack = [], count = 0;
  stack.push([rStart, cStart]);
  while (stack.length > 0) {
    let [r, c] = stack.pop();
    if (A[r][c] != NOT_VISITED) continue;
    A[r][c] = VISITED;
    ++count;
    if (r > 0) stack.push([r-1, c]);
    if (c > 0) stack.push([r, c-1]);
    if (r < N-1) stack.push([r+1, c]);
    if (c < N-1) stack.push([r, c+1]);
  }
  return count;
}