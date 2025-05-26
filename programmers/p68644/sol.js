function solution(numbers) {
  let set = new Set(), N = numbers.length;
  for (let i = 0; i < N - 1; ++i)
    for (let j = i + 1; j < N; ++j)
      set.add(numbers[i] + numbers[j]);
  return [...set].sort((a, b) => a - b);
}

console.log(solution([2,1,3,4,1]));
console.log(solution([5,0,2,7]));