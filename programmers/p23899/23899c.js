function selectionSort(A, B) {
  if (A.every((v, i) => v == B[i])) return true;
  for (let i = A.length - 1; i > 0; --i) {
    let maxIndex = i;
    for (let j = 0; j < i; ++j)
      if (A[j] > A[maxIndex]) maxIndex = j;
    [A[maxIndex], A[i]] = [A[i], A[maxIndex]];
    if (A.every((v, i) => v == B[i])) return true;
  }
  return false;
}

let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let A = input[1].split(' ').map(e => Number(e));
let B = input[2].split(' ').map(e => Number(e));
console.log(selectionSort(A, B) ? '1' : '0');
