let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let M = parseInt(input[index++]);
let A = [];
for (let i = 0; i < M; ++i)
  A[i] = parseInt(input[index++]);
console.log(파라매트릭서치_최소값(1, 1_000_000_000));

function compare(질투심) {
  let count = 0;
  for (let i of A)
    count += Math.ceil(i / 질투심);
  return N - count;
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