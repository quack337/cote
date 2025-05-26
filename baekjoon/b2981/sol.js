function 최대공약수(a, b) {
  while (b != 0) {
    let t = a % b;
    a = b;
    b = t;
  }
  return a;
}

function 최대공약수_배열(a) {
  let result = a[0];
  for (let i = 1; i < a.length; ++i)
    result = 최대공약수(result, a[i]);
  return result;
}

function 약수찾기(value) {
  let set = new Set();
  let end = Math.sqrt(value);
  for (let i = 2; i <= end; ++i)
    if (value % i == 0) {
      set.add(i);
      set.add(value / i);
    }
  return [...set].sort((a, b) => a - b);
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let N = parseInt(input[0]);
let A = []
for (let i = 0; i < N; ++i) {
  A[i] = parseInt(input[i + 1]);
}
A.sort((a, b) => a - b);
let B = [];
for (let i = 0; i < N - 1; ++i)
  B[i] = A[i + 1] - A[i];
let gcd = 최대공약수_배열(B);
let list = 약수찾기(gcd);
list.push(gcd);
console.log(list.join(' '));
