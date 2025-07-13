function compare(middle) {
  let count = 1, 남은용량 = middle;
  for (let 영상 of A)
    if (영상 <= 남은용량)
       남은용량 -= 영상;
    else  {
       ++count;
       남은용량 = middle - 영상;
    }
  return M - count;
}

let A = [1, 1]; // 크기 1 영상 2개를
let M = 1; // 블루레이 1장에 담으려면
console.log(compare(1) < 0); // 크기 1 블루레이에 담으려면 2장 필요. 1은 너무작다. 음수 리턴해야함.
console.log(compare(2) == 0); // 크기 2 블루레이에 담으려면 1장 필요. 2는 적당하다. 0 리턴해야함.
console.log(compare(3) == 0); // 크기 3 블루레이에 담으려면 1장 필요. 3도 적당하다. 0 리턴해야함.

