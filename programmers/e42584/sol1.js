function solution(prices) {
  let answer = [], N = prices.length;
  for (let i = 0; i < N; ++i) // 현재 인덱스
    for (let j = i - 1; j >= 0; --j) { // 떨어질 항목 찾기
      if (prices[j] == 0) continue; // 이미 제거됨
      if (prices[j] > prices[i]) { // 떨어질 항목 발견
        answer[j] = i - j; // 현재 인덱스 - 떨어지는 항목의 인덱스
        prices[j] = 0; // 제거
      }
      else // prices[j] <= prices[i] 이므로 떨어지지 않는다.
        break; // j 보다 왼쪽 값들 중 prices[j] 값보다 큰 것들은
               // 이미 다 떨어졌을 것이다. 따라서 더 찾아볼 필요 없다
    }
  for (let i = 0; i < N; ++i)
    if (prices[i] > 0) // 끝까지 남은 항목 발견
      answer[i] = N - 1 - i;  // 남은 항목의 인덱스 - 마지막 항목의 인덱스
  return answer;
}

console.log(solution([1, 2, 3, 2, 3]));
