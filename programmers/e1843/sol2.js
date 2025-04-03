function solution(ar) {
  let DPmax = [], DPmin = [];
  for (let i = 0; i < ar.length; ++i) {
    DPmax[i] = Array(ar.length).fill(null);
    DPmin[i] = Array(ar.length).fill(null);
  }
  function maxValue(from, to) {
    if (DPmax[from][to] != null) return DPmax[from][to];
    if (from == to) return DPmax[from][to] = parseInt(ar[from]);
    let result = -999_999_999;
    for (let i = from + 1; i < to; i += 2) {
      let value = (ar[i] == "+") ?
        maxValue(from, i - 1) + maxValue(i + 1, to) : 
        maxValue(from, i - 1) - minValue(i + 1, to);
      if (value > result) result = value;
    }
    return DPmax[from][to] = result;
  }
  function minValue(from, to) {
    if (DPmin[from][to] != null) return DPmin[from][to];
    if (from == to) return DPmin[from][to] = parseInt(ar[from]);
    let result = +999_999_999;
    for (let i = from + 1; i < to; i += 2) {
      let value = (ar[i] == "+") ?
        minValue(from, i - 1) + minValue(i + 1, to) : 
        minValue(from, i - 1) - maxValue(i + 1, to);
      if (value < result) result = value;
    }
    return DPmin[from][to] = result;
  }
  return maxValue(0, ar.length - 1);
}

console.log(solution(["1", "-", "3", "+", "5", "-", "8"]));
console.log(solution(["5", "-", "3", "+", "1", "+", "2", "-", "4"]));
  