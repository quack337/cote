function 최대공약수(a, b){
  while (b != 0) {
    let t = a % b;
    a = b;
    b = t;
  }
  return a;
}

function 최소공배수(a, b) {
  return a * b / 최대공약수(a, b);
}

function solution(a) {
  let result = a[0];
  for (let i = 1; i < a.length; ++i)
      result = 최소공배수(result, a[i]);
  return result;
}

console.log(solution([2,6,8,14]));
console.log(solution([1,2,3]));

