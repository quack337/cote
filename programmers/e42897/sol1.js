function solution(money) {
  let DP = [];
  function sol(index) {
    if (DP[index]) return DP[index];
    if (index >= money.length) return 0;
    if (index == money.length - 1) return money[index];
    let r1 = sol(index + 1);
    let r2 = money[index] + sol(index + 2);
    return DP[index] = r1 > r2 ? r1 : r2;
  }
  return sol(0);
}

console.log(solution([1, 2, 3, 1]));