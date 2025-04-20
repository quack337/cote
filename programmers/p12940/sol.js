function 최대공약수(a, b) {
  while (b !== 0) {
    let t = a % b;
    a = b;
    b = t;
  }
  return a;
}

function 최소공배수(a, b) {
  return (a * b) / 최대공약수(a, b);
}

function solution(a, b) {
  return [최대공약수(a, b), 최소공배수(a, b)];
}

console.log(solution(3, 12));
console.log(solution(2, 5));
