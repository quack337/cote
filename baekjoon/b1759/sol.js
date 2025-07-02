let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let L = getInt(), N = getInt();
let selected = [], selectCount = 0;
let A = [], answer = [];
for (let i = 0; i < N; ++i)
  A[i] = getStr();
A.sort();
DFS(0, N - L);
console.log(answer.join('\n'));

function DFS(from, to) {
  if (selectCount == L) {
    if (isValidPasswd()) answer.push(selected.join(''));
    return;
  }
  for (let i = from; i <= to; ++i) {
    selected[selectCount] = A[i];
    ++selectCount;
    DFS(i + 1, to + 1);
    --selectCount;
  }
}

function isValidPasswd() {
  let 모음 = 0, 자음 = 0;
  for (let ch of selected)
    if ('aeiou'.indexOf(ch) >= 0) ++모음;
    else ++자음;
  return 모음 >= 1 & 자음 >= 2;
}