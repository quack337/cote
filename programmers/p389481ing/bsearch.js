function binarySearch(arr, value, compare) {
  let start = 0;
  let end = arr.length - 1;
  while (start <= end) {
      let middle = (end + start) >> 1;
      let r = compare(value, arr[middle]);
      if (r > 0) start = middle + 1;
      else if(r < 0) end = middle - 1;
      else {
        if (start == middle)
          return compare(value, arr[end]) == 0 ? end : start;
        else start = middle;
      }
  }
  return ~start;
}

function test(arr, value, compare) {
  for (let i = arr.length - 1; i >= 0; --i)
    if (value == arr[i]) return i;
  return -1;
}

let arr = [5,5,7,7,7,9,9,9,9,11];
const compare = (a, b) => a - b;
for (let i = 0; i < 10000; ++i) {
  if (binarySearch(arr, 5, compare) != test(arr, 5)) break;
  if (binarySearch(arr, 7, compare) != test(arr, 7)) break;
  if (binarySearch(arr, 9, compare) != test(arr, 9)) break;
  arr.unshift(0);
  console.log(i);
}
