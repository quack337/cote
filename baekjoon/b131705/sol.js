function solution(ar) {
  let N = ar.length, answer = 0;
  for (let a = 0; a < N - 2; ++a)
    for (let b = a + 1; b < N - 1; ++b)
      for (let c = b + 1; c < N; ++c)
        if (ar[a] + ar[b] + ar[c] == 0)
          ++answer;
  return answer;
}

console.log(solution([-2, 3, 0, 2, -5]));
console.log(solution([-3, -2, -1, 0, 1, 2, 3]));
console.log(solution([-1, 1, -1, 1]));