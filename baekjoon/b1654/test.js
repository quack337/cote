let A = [], N = 0;

function compare(middle) {
  let count = 0;
  for (let lan of A)
    count += Math.floor(lan / middle)
  return N - count;
}

A = [10]; N = 2;
console.log(compare(7) > 0); // 길이 7로 자르면 1개, 7이 너무 크다, 양수 리턴
console.log(compare(6) > 0); // 길이 6으로 자르면 1개, 6이 너무 크다, 양수 리턴
console.log(compare(5) == 0); // 길이 5로 자르면 2개, ok
console.log(compare(4) == 0); // 길이 4로 자르면 2개, ok
console.log(compare(3) < 0); // 길이 3으로 자르면 3개, 3이 너무 작다, 음수 리턴
console.log(compare(2) < 0); // 길이 2로 자르면 5개, 2가 너무 작다, 음수 리턴
