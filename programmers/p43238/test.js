function compare(middle) {
  let sum = 0;
  for (let time of times) {
    let temp = Math.floor(middle / time);
    if (temp > N) return 1;
    sum += temp;
    if (sum > N) return 1;
  }
  return sum - N;
}

let times = [2, 3]; // 2분, 3분 2개의 심사대
let N = 2; // 2명을 처리해야 함
console.log(compare(1) < 0); // 1분에 2명 처리할 수 없다. 음수 리턴
console.log(compare(2) < 0); // 2분에 2명 처리할 수 없다. 음수 리턴
console.log(compare(3) == 0); // 3분에 2명 처리할 수 있다. 0 리턴
console.log(compare(4) > 0); // 4분에 3명 처리할 수 있다. 양수 리턴

let a = 1_111_111_111_111_111_111n;
console.log(a);
