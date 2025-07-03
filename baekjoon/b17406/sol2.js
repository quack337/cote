// rotate 구현: data2로 테스트
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
print();
rotate(OP[0]);
print();

function rotate(op) {
  for (let s = 1; s <= op.s; ++s) {
    let r1 = op.r-s, c1 = op.c-s, r2 = op.r+s, c2 = op.c+s;
    let temp = A[r1][c1];
    for (let r = r1; r < r2; ++r) A[r][c1] = A[r+1][c1];
    for (let c = c1; c < c2; ++c) A[r2][c] = A[r2][c+1];
    for (let r = r2; r > r1; --r) A[r][c2] = A[r-1][c2];
    for (let c = c2; c > c1; --c) A[r1][c] = A[r1][c-1];
    A[r1][c1+1] = temp;
  }
}

function print() {
  for (let r = 0; r < ROW; ++r)
    console.log(A[r]);
  console.log();
}