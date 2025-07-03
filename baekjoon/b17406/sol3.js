// value 구현: data1, data2로 테스트
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());

let ROW = getInt(), COL = getInt(), N = getInt();
let A = Array(ROW).fill().map(() => []);
for (let r = 0; r < ROW; ++r)
  for (let c = 0; c < COL; ++c)
    A[r][c] = getInt();
let OP = [];
for (let i = 0; i < N; ++i)
  OP[i] = {r: getInt()-1, c: getInt()-1, s: getInt()};
console.log(value(A));

function value(A) {
  return A.map(row => row.reduce((r, e) => r + e), 0)
          .reduce((r, e) => Math.min(r, e), Number.MAX_VALUE);
}