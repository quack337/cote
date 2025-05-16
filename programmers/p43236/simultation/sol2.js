
function solution(distance, rocks, n) {
  rocks.sort((a, b) => a - b);
  rocks.push(distance);
  console.log(제거해야할_바위_수(4));
  return;

  let start = 0, end = distance;
  while (start <= end) {
    let middle = (start + end) >> 1;
    let count = 제거해야할_바위_수(middle);
    if (count > n) end = middle - 1;
    else if (count < n) start = middle + 1;
    else return middle;
  }
  return -1;

  function 제거해야할_바위_수(거리) {
    let 이전위치 = 0, count = 0;
    for (let i = 0; i < rocks.length; ++i)
      if (rocks[i] - 이전위치 < 거리) {
        console.log("제거", i, rocks[i]);
        ++count;
      } else
        이전위치 = rocks[i];
    return count;
  }
}

console.log(solution(25, [2, 14, 11, 21, 17], 2));
// 2 11 14 17 21 25