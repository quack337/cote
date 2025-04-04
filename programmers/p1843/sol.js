function solution(ar) {
  // from, to 구간에서 최대값 최소값 구하기
  function maxValue(from, to) {
    if (from == to) return parseInt(ar[from]);
    let result = -999_999_999;
    for (let i = from + 1; i < to; i += 2) {
      let value = (ar[i] == "+") ?
        maxValue(from, i - 1) + maxValue(i + 1, to) : 
        maxValue(from, i - 1) - minValue(i + 1, to);
      if (value > result) result = value;
    }
    return result;
  }
  function minValue(from, to) {
    if (from == to) return parseInt(ar[from]);
    let result = +999_999_999;
    for (let i = from + 1; i < to; i += 2) {
      let value = (ar[i] == "+") ?
        minValue(from, i - 1) + minValue(i + 1, to) : 
        minValue(from, i - 1) - maxValue(i + 1, to);
      if (value < result) result = value;
    }
    return result;
  }
  return maxValue(0, ar.length - 1);
}

console.log(solution(["1", "-", "3", "+", "5", "-", "8"]));
console.log(solution(["5", "-", "3", "+", "1", "+", "2", "-", "4"]));
  