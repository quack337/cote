function compare(middle) {
  let sum = 0;
  for (let tree of A)
    if (tree > middle)
      sum += tree - middle;
  return M - sum;
}

let A = [3, 4, 5]; // 높이 3, 4, 5 인 나무를 잘라서
let M = 2; // 2미터를 얻으려고 한다
console.log(compare(1) < 0); // 높이 1은 너무 낮다. 음수를 리턴
console.log(compare(2) < 0); // 높이 2도 너무 낮다. 음수를 리턴
console.log(compare(3) < 0); // 높이 3으로 자르면 3을 얻는다. 너무 낮다. 음수 리턴
console.log(compare(4) > 0); // 높이 4로 자르면 1을 얻는다. 너무 높다. 양수 리턴

A = [3, 4, 5]; // 높이 3, 4, 5 인 나무를 잘라서
M = 3; // 3미터를 얻으려고 한다
console.log(compare(1) < 0); // 높이 1은 너무 낮다. 음수를 리턴
console.log(compare(2) < 0); // 높이 2도 너무 낮다. 음수를 리턴
console.log(compare(3) == 0); // 높이 3으로 자르면 3을 얻는다. ok 0 리턴
console.log(compare(4) > 0); // 높이 4로 자르면 1을 얻는다. 너무 높다. 양수 리턴
