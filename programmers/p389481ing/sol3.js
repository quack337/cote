function 주문to정수(주문) {
  let value = 0, A_CODE = 'a'.charCodeAt(0);
  for (let ch of 주문)
    value = value * 26 + (ch.charCodeAt(0) - A_CODE);
  return value;
}

function 정수to주문(value) {
  let result = "", A_CODE = 'a'.charCodeAt(0);
  if (value == 0) return 'a';
  while (value > 0) {
    let 자릿수 = value % 26;
    result = String.fromCharCode(자릿수 + A_CODE) + result;
    value = Math.floor(value / 26);
  }
  return result
}

function binarySearch(arr, value, compare) {
  let start = 0;
  let end = arr.length - 1;
  while (start <= end) {
      let middle = (end + start) >> 1;
      let r = compare(value, arr[middle]);
      if (r > 0) start = middle + 1;
      else if(r < 0) end = middle - 1;
      else return middle;
  }
  return ~start;
}

function count(bans, x) {
  let index = binarySearch(bans, x, (a, b) => a - b);
  return index >= 0 ? index : -index - 1;
}

function parametricSearch(N, bans) {
  let start = 0;
  let end = 주문to정수('zzzzzzzzzzz');
  while (start <= end) {
    let middle = Math.floor((end + start) / 2 );
    let value = N - 1 + count(bans, middle);
    if (value > middle) start = middle + 1;
    else if (value < middle) end = middle - 1;
    else {
      if (start == middle)
        return (N - 1 + count(bans, end)) == end ? end : start;
      else start = middle;
    }
  }
  return ~start;
}

function solution(N, bans) {
  let bans2 = bans.map(b => 주문to정수(b));
  console.log(bans2);
  bans2.sort((a, b) => a - b);
  console.log(bans2);
  let value = parametricSearch(N, bans2);
  if (value < 0) throw "발생할 것 같지 않은 에러";
  console.log(value);
  return 정수to주문(value);
}

console.log(solution(30, ["d", "e", "bb", "aa", "ae"]));
