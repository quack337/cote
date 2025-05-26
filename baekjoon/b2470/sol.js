let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let ii = 0, getInt = () => parseInt(input[ii++]);
let N = getInt(), A = [];
for (let i = 0; i < N; ++i)
  A[i] = getInt();
A.sort((a, b) => a - b);

function binarySearch(value) {
  let left = 0, right = A.length - 1;
  while (left <= right) {
    let middle = Math.floor((left + right) / 2);
    if (value < A[middle]) right = middle - 1;
    else if (value > A[middle]) left = middle + 1;
    else return middle;
  }
  return -left - 1;
}

let min = 2_000_000_000, i1, i2;
let checkMin = (i, j) => {
  if (i != j && i >= 0 && j < N && Math.abs(A[i] + A[j]) < min) {
    min = Math.abs(A[i] + A[j]);
    i1 = i; i2 = j;
  }
}

for (let i = 0; A[i] <= 0; ++i) {
  let j = binarySearch(-A[i]);
  if (j > -1) {
    console.log(A[i], A[j])
    return;
  } else {
    checkMin(i, -j - 1);
    checkMin(i, -j - 2);
  }
}

let j = binarySearch(0);
if (j < 0) j = -j - 1;
for (let i = j - 2; i <= j; ++i)
  checkMin(i, i + 1);

console.log(A[i1], A[i2]);
