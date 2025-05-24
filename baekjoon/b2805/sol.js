let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let N = parseInt(input[0]);
let M = parseInt(input[1]);
let A = [], max = 0
for (let i = 0; i < N; ++i) {
  A[i] = parseInt(input[i + 2]);
  if (A[i] > max) max = A[i];
}

console.log(파라매트릭서치_최대값(0, max));

function compare(middle) {
  let sum = 0;
  for (let tree of A)
    if (tree > middle)
      sum += tree - middle;
  return M - sum;
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
