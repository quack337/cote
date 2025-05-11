let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let N = parseInt(input[0]);
let S = parseInt(input[1]);
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = parseInt(input[i + 2]);

let answer = 0;
DFS(0, 0, 0);
console.log(answer);

function DFS(index, count, sum) {
  if (index == A.length) {
    if (count > 0 && sum == S) ++answer;
    return;
  }
  DFS(index + 1, count, sum);
  DFS(index + 1, count + 1, sum + A[index]);
}