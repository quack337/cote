
function compare(length) {
  let count = 0;
  for (let 과자 of A)
    count += Math.floor(과자 / length)
  return M - count;
}

let A = [2, 2]; // 크기 2 과제 2개를
let M = 2; // 2명의 조카에게 나눠줘야 한다.
console.log(compare(1) < 0); // 크기 1로 자르면 4개. 너무 많다. 더 크게 잘라야 한다. 음수 리턴
console.log(compare(2) == 0); // 크기 2로 자르면 2개. 0 리턴.

A = [2, 2]; // 크기 2 과제 2개를
M = 3; // 3명의 조카에게 나눠줘야 한다.
console.log(compare(1) < 0); // 크기 1로 자르면 4개. 너무 많다. 더 크게 잘라야 한다. 음수 리턴
console.log(compare(2) > 0); // 크기 2로 자르면 2개. 너무 적다. 다 작게 잘라야 한다. 양수 리턴

