function 정렬(arr) {
  const counts = new Map();
  for (const key of arr) {
    if (key === 0) continue;
    const count = counts.get(key) || 0;
    counts.set(key, count + 1);
  }
  const entries = Array.from(counts.entries());
  entries.sort((a, b) => {
    const r = a[1] - b[1];
    if (r !== 0) return r;
    return a[0] - b[0];
  });
  const result = [];
  for (const [key, value] of entries)
    result.push(key, value);
  return result;
}

function 크기조정(arr) {
  let size = 0;
  for (const row of arr)
    size = Math.min(100, Math.max(size, row.length));
  for (let i = 0; i < arr.length; i++)
    arr[i] = (arr[i].length >= size) ? arr[i].slice(0, size) :
              arr[i].concat(Array(size - arr[i].length).fill(0));
}

function R연산(arr) {
  const result = arr.map(row => 정렬(row));
  크기조정(result);
  return result;
}

function 회전(arr) {
  let result = Array(arr[0].length).fill().map(e => Array(arr.length));
  for (let r = 0; r < arr.length; r++)
    for (let c = 0; c < arr[0].length; c++)
      result[c][r] = arr[r][c];
  return result;
}

function C연산(arr) {
  arr = 회전(arr);
  arr = R연산(arr);
  return 회전(arr);
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let 목표_행 = parseInt(input[index++]) - 1;
let 목표_열 = parseInt(input[index++]) - 1;
let 목표_수 = parseInt(input[index++]);
let a = Array(3).fill().map(e => Array(3))
for (let r = 0; r < 3; ++r)
  for (let c = 0; c < 3; ++c)
    a[r][c] = parseInt(input[index++]);

for (let time = 0; time <= 100; ++time) {
  if (a.length > 목표_행 && a[0].length > 목표_열 && a[목표_행][목표_열] == 목표_수) {
    console.log(time);
    return;
  }
  if (a.length >= a[0].length)
    a = R연산(a);
  else
    a = C연산(a);
}
console.log(-1);

