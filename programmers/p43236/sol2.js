
function solution(distance, rocks, n) {
  rocks.push(distance);
  let start = 0, end = 1_000_000_000;
  while (start <= end) {
    let middle = Math.ceil((start + end) / 2);
    if (value < middle) end = middle - 1;
    else if (value > middle) start = middle + 1;
    else return middle;
  }
  return -1;

  function 제거해야할_바위_수(거리) {
    let 이전위치 = 0, count = 0;
    for (let i = 0; i < rocks.length; ++i)
      if (rocks[i] - 이전위치 < 거리)
        ++count;
      else
        이전위치 = rocks[i];

  }
}

for (let i = 0; i <= 1_000_000_000; ++i) {
  if (i % 10_000_000 == 0)
    console.log(i);
  if (i != sol(i)) {
    console.error(i, sol(i));
    break;
  }
}

//solution(25, [2, 14, 11, 21, 17], 2);