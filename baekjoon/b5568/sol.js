let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => parseInt(input[idx++]);
let N = getInt(), R = getInt();
let A = [];
let V = [];
let answer = new Set();
for (let i = 0; i < N; ++i)
  A[i] = getInt();
DFS(0, 0);
console.log(answer.size);

function DFS(n, x) { // n: 지금까지 선택한 갯수, x: 선택한 수들로 계산한 값
  if (n == R) {
    answer.add(x);
    return;
  }
  for (let i = 0; i < N; ++i)
    if (!V[i]) {
      V[i] = true;
      DFS(n+1, x * (A[i]>9 ? 100 : 10) + A[i]);
      V[i] = false;
    }
}
