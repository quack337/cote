function solution(n, times) {
  n = BigInt(n);
  return 파라매트릭서치_최소값(1n, 1_000_000_000_000_000_000n);

  function compare(시간) {
    let count = 0n;
    for (let i of times) {
      i = BigInt(i);
      let temp = 시간 / i;
      if (temp >= n) return 1;
      count += (시간 / i)
      if (count >= n) return 1;
    }
    return count - n;
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
