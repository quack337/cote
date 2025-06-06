function solution(다리길이, 다리_허용중량, 트럭중량) {
  const 다리_큐 = [];
  let 경과시간 = 0, 현재트럭 = 0, 다리위_트럭들_중량 = 0, 건넌_트럭수 = 0;
  while (건넌_트럭수 < 트럭중량.length) {
    경과시간++;
    if (다리_큐.length === 다리길이) {
      const 건넌트럭중량 = 다리_큐.shift();
      다리위_트럭들_중량 -= 건넌트럭중량;
      if (건넌트럭중량 > 0) 건넌_트럭수++;
    }
    if (현재트럭 < 트럭중량.length && 다리위_트럭들_중량 + 트럭중량[현재트럭] <= 다리_허용중량) {
      다리_큐.push(트럭중량[현재트럭]);
      다리위_트럭들_중량 += 트럭중량[현재트럭];
      ++현재트럭;
    } else
      다리_큐.push(0);
  }
  return 경과시간;
}

console.log(solution(2, 10, [7, 4, 5, 6]));
console.log(solution(100, 100, [100]));
console.log(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]));
