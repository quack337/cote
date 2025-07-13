let A = [], M = 0;

function compare(middle) {
  let count = 1, 남은금액 = middle;
  for (let 지출 of A) {
    if (지출 > 남은금액) {
      ++count;
      남은금액 = middle;
    }
    남은금액 -= 지출;
  }
  return M - count;
}

A = [2, 2]; M = 1;
console.log(compare(4) == 0); // 4원 1번 인출 ok
console.log(compare(3) < 0); // 3원 2번 인출, 좀 더 큰 금액으로 인출해야 함. 3원이 적다 음수 리턴
console.log(compare(5) == 0); // 5원 1번 인출 ok

A = [2, 2, 2]; M = 2;
console.log(compare(2) < 0); // 2원 3번 인출, 좀 더 큰 금액으로 인출해야 함. 2원이 적다 음수 리턴
console.log(compare(3) < 0); // 3원 3번 인출, 좀 더 큰 금액으로 인출해야 함. 3원이 적다 음수 리턴
console.log(compare(4) == 0); // 4원 2번 인출 ok
console.log(compare(5) == 0); // 5원 2번 인출 ok
console.log(compare(6) > 0); // 6원 1번 인출, 좀 더 작은 금액으로 인출해야 함. 6원이 크다 양수 리턴
console.log(compare(7) > 0); // 7원 1번 인출, 좀 더 작은 금액으로 인출해야 함. 7원이 크다 양수 리턴