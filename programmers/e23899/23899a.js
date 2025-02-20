function selectionSort(A, B_joined) {
  if (A.ev.join('') == B_joined) return true;
  for (let i = A.length - 1; i > 0; --i) {
    let maxIndex = i;
    for (let j = 0; j < i; ++j)
    if (A[j] > A[maxIndex]) maxIndex = j;
    [A[maxIndex], A[i]] = [A[i], A[maxIndex]];
    if (A.join('') == B_joined) return true;
  }
  return false;
}

let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let N = Number(input[0]);
let A = [], B = [];
for (let a of input[1].split(' '))
  A.push(Number(a));
for (let b of input[2].split(' '))
  B.push(Number(b));
console.log(selectionSort(A, B.join('')) ? '1' : '0');
