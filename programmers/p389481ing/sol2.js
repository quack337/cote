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
  let end = 100000;
  while (start <= end) {
    let middle = (end + start) >> 1;
    if (start < 0) return;
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

console.log(parametricSearch(10, [3,5,7])); // 12
console.log(parametricSearch(10, [3,5,7,12])); // 13
console.log(parametricSearch(10, [3,5,7,12,13,16,17])); // 14
console.log(parametricSearch(10, [3,5,7,12,13,14,16,17])); // 15
