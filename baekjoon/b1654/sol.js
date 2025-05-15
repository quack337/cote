let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let N = parseInt(input[0]);
let M = parseInt(input[1]);
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = parseInt(input[i + 2]);

console.log(파라매트릭서치_최대값(1, Math.pow(2, 31) - 1));

function compare(length) {
  let count = 0;
  for (let lan of A)
    count += Math.floor(lan / length)
  return M - count;
}

function 파라매트릭서치_최대값(min, max) {
  let left = min, right = max;
  while (left < right) {
    let middle = Math.floor((left + right) / 2);
    let r = compare(middle);
    if (r > 0)
      right = middle;
    else
      left = middle + 1;
  }
  return right - 1;
}