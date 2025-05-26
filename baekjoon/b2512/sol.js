let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let A = [], sum = 0, max = 0;
for (let i = 0; i < N; ++i) {
  A[i] = parseInt(input[index++]);
  if (A[i] > max) max = A[i];
  sum += A[i];
}
let M = parseInt(input[index++]);

if (sum <= M) console.log(max);
else console.log(파라매트릭서치_최대값(1, M));

function compare(상한) {
  let sum = 0;
  for (let i of A)
    sum += Math.min(i, 상한)
  return sum - M;
}

function 파라매트릭서치_최대값(left, right) {
  while (left <= right) {
    let middle = Math.floor((left + right) / 2);
    let r = compare(middle);
    if (r <= 0)
      left = middle + 1;
    else
      right = middle - 1;
  }
  return right;
}