function solution(n, prev = 0) {
  if (n == 0) return 1;
  let result = 0;
  for (let i = prev + 1; i >= 1; --i)
    result += solution(n - 1, i);
  return result;
}

console.log(solution(1));
console.log(solution(2));
console.log(solution(3));
console.log(solution(4));