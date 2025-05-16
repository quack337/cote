// 정답. 그렇지만 군더더기 코드
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let N = parseInt(input[0]);
let C = parseInt(input[1]);
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = parseInt(input[i + 2]);

A.sort((a, b) => a - b);
console.log(파라매트릭서치_최대값(1, 1_000_000_000));

function compare(distance) {
  let count = 1, prev = A[0];
  for (let i = 1; i < A.length; ++i)
    if (A[i] - prev >= distance) {
      prev = A[i];
      ++count;
    }
  return C - count;
}

function 파라매트릭서치_최대값(left, right) {
  let answer = -1;
  while (left <= right) {
    let middle = Math.floor((left + right) / 2);
    let r = compare(middle);
    if (r < 0) {
      answer = middle; // 왜 이 코드를 넣어야 하지?
      left = middle + 1;
    } else if (r > 0)
      right = middle - 1;
    else {
      answer = middle;
      left = middle + 1;
    }
  }
  return answer;
}

/*
answer = middle; // 왜 이 코드를 넣어야 하지?

필요한 이유,
 파라매트릭 서치는,
   계산결과가 목표값(C)과 일치하는 파라미터 값을 찾는 것이다.
   그런데 목표값과 정확하게 일치하는 파라미터 값이 정수가 아닐 수도 있다.
   따라서 근사치를 찾아야 한다.

   위 문제의 경우, C개의 공유기를 요구하는 거리를 찾는 것이다.
   입력이 집 좌표가 1 2 3 4 5 이고, 공유기를 4개 놓으려고 할 때,
    거리 2 => 공유기 3개
    거리 1 => 공유기 5개

    정확하게
*/

