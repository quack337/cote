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

let N = 10, bans = [3,5,7,12,13,16,17];
for (let x = 0; x < 20; ++x) {
  let value = N - 1 + count(bans, x);
  let 답 = (x == value) && (bans.includes(x) == false);
  console.log(`N - 1 + count(${x}) = ${value}`, 답);
}
