function solution(N, times) {
  N = BigInt(N);
  return 파라매트릭서치_최소값(1n, 1_000_000_000_000_000_000n);

  function compare(middle) {
    let sum = 0n;
    for (let time of times) {
      time = BigInt(time);
      let temp = middle / time;
      if (temp >= N) return 1;
      sum += temp;
      if (sum > N) return 1;
    }
    return sum - N;
  }

  function 파라매트릭서치_최소값(left, right) {
    while (left <= right) {
      let middle = (left + right) / BigInt(2);
      let r = compare(middle);
      if (r >= 0)
        right = middle - 1n;
      else
        left = middle + 1n;
    }
    return Number(left);
  }
}

console.log(solution(6, [7, 10]));
