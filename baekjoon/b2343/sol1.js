// 버그 testSS("2 2\n1 2", "2")

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let M = parseInt(input[index++]);
let A = []
for (let i = 0; i < N; ++i)
  A[i] = parseInt(input[index++]);
console.log(파라매트릭서치_최소값(1, 1_000_000_000));

function compare(블루레이크기) {
  let count = 1, 영상크기합계 = 0;
  for (let 영상 of A) {
    if (영상 + 영상크기합계 > 블루레이크기) {
      ++count;
      영상크기합계 = 영상;
    } else
      영상크기합계 += 영상;
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