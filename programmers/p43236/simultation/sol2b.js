function 제거해야할_바위_수(rocks, 최소거리) {
  let 이전위치 = 0, count = 0;
  let 남은바위들 = []
  for (let i = 0; i < rocks.length; ++i)
    if (rocks[i] - 이전위치 < 최소거리)
      ++count;
    else {
      남은바위들.push(rocks[i]);
      이전위치 = rocks[i];
    }
  console.log("바위들", rocks);
  console.log("최소거리", 최소거리);
  console.log("남은 바위들", 남은바위들);
  return count;
}

let rocks = [2, 11, 14, 17, 21, 25];
for (let d = 1; d <= 25; ++d)
  console.log("제거 수", 제거해야할_바위_수(rocks, d), "\n\n");
