let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let N = parseInt(input[0]);
let M = parseInt(input[1]);
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = parseInt(input[i + 2]);
console.log(파라매트릭서치_최대값(0, 1_000_000_000));

function compare(height) {
  let sum = 0;
  for (let tree of A)
    if (tree > height) 
      sum += tree - height;
  return M - sum;
}

function 파라매트릭서치_최대값(min, max) {
  let left = min, right = max;
  while (left < right) {
    let middle = (left + right) >> 1;
    let r = compare(middle);
    if (r > 0)
      right = middle;
    else
      left = middle + 1;
  }
  return right - 1;
}