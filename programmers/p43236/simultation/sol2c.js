function 제거해야할_바위_수(rocks, 최소거리) {
  let 이전위치 = 0, count = 0;
  for (let i = 0; i < rocks.length; ++i)
    if (rocks[i] - 이전위치 < 최소거리)
      ++count;
    else
      이전위치 = rocks[i];
  return count;
}

function solution(distance, rocks, n) {
  rocks.sort((a, b) => a - b);
  rocks.push(distance);
  let start = 0, end = distance;
  while (start <= end) {
    let middle = (start + end) >> 1;
    let count = 제거해야할_바위_수(rocks, middle);
    //console.log(middle, count);
    if (count > n) end = middle - 1;
    else if (count < n) start = middle + 1;
    else return middle;
  }
  return -1;
}

for (let n = 1; n <= 5; ++n)
  console.log("제거", n, "최소거리", solution(25, [2, 14, 11, 21, 17], n));
