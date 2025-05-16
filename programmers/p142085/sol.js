function solution(n, k, enemies) {
  return 파라매트릭서치_최대값(k, enemies.length);

  function compare(라운드) {
    let enemies2 = enemies.slice(0, 라운드).sort((a, b) => b - a);
    let sum = 0;
    for (let i = k; i < enemies2.length; ++i)
      sum += enemies2[i];
    return sum - n;
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

console.log(7, 3, [4, 2, 4, 5, 3, 3, 1]);