function binarySearch_rightmost(arr, value) {
  let left = 0, right = arr.length - 1, answer = -1;
  while (left <= right) {
    let middle = left + Math.floor((right - left) / 2);
    if (arr[middle] < value)
      left = middle + 1;
    else if (arr[middle] > value)
      right = middle - 1;
    else {
      answer = middle;
      left = middle + 1;
    }
  }
  return answer >= 0 ? answer : -left - 1;
}

let ar = [1, 1, 3, 3, 3, 5, 7, 7, 9];
for (let i = 1; i <= 9; i += 2) {
  let index = binarySearch_rightmost(ar, i);
  console.log("%d: %d", i, index);
}
for (let i = 0; i <= 10; i += 2) {
  let index = binarySearch_rightmost(ar, i);
  console.log("%d: %d, %d", i, index, -index - 1);
}
