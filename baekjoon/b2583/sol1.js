// 재귀 DFS
// 벽 그리기가 관건. 벽 그리기 테스트
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let ROW = getInt(), COL = getInt(), K = getInt();
let 벽 = 1, 탐색할칸 = 0;
let A = Array(ROW).fill().map(() => Array(COL).fill(탐색할칸));
let visited = Array(ROW).fill().map(() => []);
for (let i = 0; i < K; ++i) {
  let c1 = getInt(), r1 = getInt(), c2 = getInt(), r2 = getInt();
  for (let r = r1; r < r2; ++r)
    for (let c = c1; c < c2; ++c)
      A[r][c] = 벽;
}
print();

function print() {
  for (let r = 0; r < ROW; ++r)
    console.log(A[ROW-r-1].join('').replaceAll('0','.').replaceAll('1','#'));
  console.log();
}