function solution(distance, rocks, n) {
  rocks.push(distance);
  rocks.sort((a, b) => a - b);

  return 파라매트릭서치_최대값(1, 1_000_000_000);

  function compare(거리) {
    let count = 0, prev = 0;
    for (let i = 0; i < rocks.length; ++i) {
      let 구간 = rocks[i] - prev;
      if (구간 < 거리) ++count;
      else prev = rocks[i];
    }
    //console.log(거리, count);
    return count - n;
  }

  function 파라매트릭서치_최대값(left, right) {
    while (left <= right) {
      let middle = Math.floor((left + right) / 2);
      let r = compare(middle);
      if (r <= 0)
        left = middle + 1;
      else
        right = middle - 1;

    }
    return right;
  }
}

console.log(solution(4, [1, 2, 3], 1)); // 1
console.log(solution(4, [1, 2, 3], 2)); // 2
console.log(solution(4, [1, 2, 3], 3)); // 4
console.log(solution(25, [2, 14, 11, 21, 17], 2)); // 4
