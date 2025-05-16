// 메모리 초과
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let _ii = 0, getInt = () => parseInt(input[_ii++]);
let N = getInt(), A = [];
for (let i = 0; i < N; ++i)
  A[i] = getInt();
A.sort((a, b) => a - b);
let set = new Set(), map = new Map();
for (let i = 0; i < N - 1; ++i)
  for (let j = i + 1; j < N; ++j) {
    let key = A[i] + A[j];
    if (key < 0) continue;
    set.add(key);
    map.set(key, [i, j]);
  }
let B = [...set];
B.sort((a, b) => a - b);

function binarySearch(ar, value) {
  let left = 0, right = ar.length - 1;
  while (left <= right) {
    let middle = Math.floor((left + right) / 2);
    if (value < ar[middle]) right = middle - 1;
    else if (value > ar[middle]) left = middle + 1;
    else return middle;
  }
  return -left - 1;
}

let min = 2_000_000_000, mi;
let checkMin = (i, j) => {
  if (i < 0 || i >= A.lenth || j < 0 && j >= B.length) return;
  if (Math.abs(A[i] + B[j]) < min) {
    min = Math.abs(A[i] + B[j]);
    mi = [i, ...map.get(B[j])];
  }
}

for (let i = 0; A[i] <= 0; ++i) {
  let j = binarySearch(B, -A[i]);
  if (j > -1) {
    checkMin(i, j);
  } else {
    checkMin(i, -j - 1);
    checkMin(i, -j - 2);
  }
}

let j = binarySearch(A, 0);
if (j < 0) j = -j - 1;
for (let i = j - 3; i <= j; ++i)
  if (i >= 0 && i+2 < A.length) {
    let s = Math.abs(A[i] + A[i+1] + A[i+2]);
    if (s < min) {
      min = s;
      mi = [i, i+1, i+2];
    }
  }

let [a, b, c] = mi;
let answer = [A[a], A[b], A[c]].sort((a, b) => a - b);
console.log(answer.join(' '));
