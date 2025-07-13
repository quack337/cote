function compare(middle) {
  let count = 0, prev = 0;
  for (let rock of rocks) {
    let 구간간격 = rock - prev;
    if (구간간격 < middle)
       ++count;
    else
       prev = rock;
  }
  return count - N;
}

let rocks = [2, 4]; // 바위 1개 위치 2, 목적지 4.
let N = 1; // 제거할 바위 1개
console.log(compare(1) < 0); // 간격 1보다 좁은 구간은 없다. 즉 제거되는 바위가 없다.
                             // 1이 너무 작다. 음수 리턴
console.log(compare(2) < 0); // 간격 2보다 좁은 구간은 없다. 즉 제거되는 바위가 없다.
                             // 2가 너무 작다. 음수 리턴
console.log(compare(3) == 0); // 위치 2 바위 1개를 제거하면 3보다 좁은 구간이 없다.
                              // N과 일치. 0 리턴
console.log(compare(4) == 0); // 위치 2 바위 1개를 제거하면 4보다 좁은 구간이 없다.
                              // N과 일치. 0 리턴

rocks = [1, 3, 6]; // 바위 2개 위치 1, 위치 3, 목적지 6
N = 1; // 제거할 바위 1개
console.log(compare(1) < 0); // 간격 1, 제거되는 바위가 없다. 1이 너무 작다. 음수 리턴
console.log(compare(2) == 0); // 간격 2, 바위 1개 제거. N과 일치 리턴 0
console.log(compare(3) == 0); // 간격 3, 바위 1개 제거. N과 일치 리턴 0
console.log(compare(4) > 0); // 간격 4, 바위 2개 제거. 4가 너투 크다. 양수 리턴

