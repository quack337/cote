
function solution(n, k) {
  --k;
  let answer = [];

  let numbers = [];
  for (let i = 1; i <= n; ++i)
    numbers.push(i);

  let factorial = [1,1]
  for (let i = 2; i <= 20; ++i)
    factorial[i] = i * factorial[i - 1];

  while (n > 0) {
    let i = Math.floor(k / factorial[n - 1]);
    answer.push(numbers[i]);
    numbers.splice(i, 1);
    k = k % factorial[n - 1];
    --n;
  }
  return answer;
}

console.log(solution(3, 5));
