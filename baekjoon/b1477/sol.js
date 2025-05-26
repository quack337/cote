let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let M = parseInt(input[index++]);
let L = parseInt(input[index++]);
let A = [0, L];
for (let i = 0; i < N; ++i)
  A.push(parseInt(input[index++]));
A.sort((a, b) => a - b);
console.log(파라매트릭서치_최소값(1, 1000));

function compare(거리) {
  let count = 0;
  for (let i = 1; i < A.length; ++i) {
    let 구간 = A[i] - A[i - 1];
    if (구간 % 거리 == 0) {
      count += (구간 / 거리) - 1;
    } else {
      count += Math.floor(구간 / 거리);
    }
  }
  return M - count;
}

function 파라매트릭서치_최소값(left, right) {
  while (left <= right) {
    let middle = Math.floor((left + right) / 2);
    let r = compare(middle);
    if (r >= 0)
      right = middle - 1;
    else
      left = middle + 1;
  }
  return left;
}