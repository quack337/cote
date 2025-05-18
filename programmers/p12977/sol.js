function 소수인가(n) {
  if (n == 1) return false;
  let limit = Math.sqrt(n);
  for (let i = 2; i <= limit; ++i)
    if (n % i == 0) return false;
  return true;
}

function solution(nums) {
  let N = nums.length, answer = 0;
  for (let i = 0; i < N - 2; ++i)
    for (let j = i + 1; j < N - 1; ++j)
      for (let k = j + 1; k < N; ++k)
        if (소수인가(nums[i] + nums[j] + nums[k]))
          ++answer;
  return answer;
}

console.log(solution([1,2,3,4]));
console.log(solution([1,2,7,6,4]));