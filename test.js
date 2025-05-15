function binary_search_leftmost(arr, value) {
  let left = 0, right = arr.length - 1, answer = -1;
  while (left <= right) {
    let middle = Math.floor((right + left) / 2);
    if (arr[middle] < value)
      left = middle + 1;
    else if (arr[middle] > value)
      right = middle - 1;
    else {
      answer = middle;
      right = middle - 1;
    }
  }
  return answer >= 0 ? answer : [left, right];
}

function search(arr, value) {
  for (let i = 0; i < arr.length; ++i)
    if (arr[i] == value)
      return i;
    else if (arr[i] > value)
      return [i];
  return [arr.length];
}

let list = [
  [1, 3, 5, 7, 9, 11, 12],
  [1, 1, 1, 3, 3, 5, 7, 7, 7, 7, 9, 9, 11, 11, 11, 12],
  [1], [1,1], [1,1,2], [1,1,2,2], [1,2,2], [1,1,2,2,2,3]
];
for (let arr of list)
  test(arr);
console.log("ok");

for (let t = 0; t < 100000; ++t) {
  let arr = [], N = Math.floor(Math.random() * 40 + 40);
  for (let i = 1; i < N; ++i) {
    let value = Math.floor(Math.random() * 10) + 1;
    arr.push(value);
  }
  arr.sort((a, b) => a - b);
  test(arr);
}
console.log("ok");

function test(arr) {
  for (let i = arr[0]-1; i <= arr[arr.length-1]+1; ++i) {
    let ok = true;
    let r1 = binary_search_leftmost(arr, i);
    let r2 = search(arr, i);
    if (typeof r1 == "number") {
      if (r1 != r2) {
        ok = false;
        console.log("a", r1 == r2, i, r1, r2, arr);
      }
    }
    else {
      if (r1[0] != r2[0]) {
        ok = false;
        console.log("b", r1[0] == r2[0], i, r1, r2, arr.join(','));
      }
    }
    if (!ok) throw "error";
  }
}
