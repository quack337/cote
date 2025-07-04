// 실패. 시간초과
let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt();
const DR = [-1,-1,1,1], DC = [-1,1,-1,1];
let A = Array(N).fill().map(() => []);
for (let r = 0; r < N; ++r)
  for (let c = 0; c < N; ++c)
    A[r][c] = getInt();
let 답 = 0;
DFS(A, 0, 0, 0);
console.log(답);

function print(A, 비숍수){
  console.log(비숍수);
  for (let r of A)
    console.log(r.join(' '));
}

function DFS(A, r, c, 비숍수, 남은칸수) {
  if (비숍수 > 답) { 답 = 비숍수; print(A, 비숍수); }
  if (남은칸수 == 0) return;
  if (남은칸수 < 0) throw "에러" + 남은칸수;
  for (;;) {
    if (c == N) {
      c = 0;
      if (++r == N) return;
    }
    if (A[r][c] == 1) break;
    ++c;
  }
  DFS(A, r, c+1, 비숍수, 남은칸수);
  if (A[r][c] == 1) {
    A = A.map(row => [...row]);
    A[r][c] = 2;
    남은칸수 -= 불가능칸_표시(A, r, c);
    DFS(A, r, c+1, 비숍수+1, 남은칸수);
  }
}

function 불가능칸_표시(A, r, c) {
  let count = 0;
  for (let i = 0; i < 4; ++i) {
    let r2 = r, c2 = c;
    for (;;) {
      r2 += DR[i]; c2 += DC[i];
      if (r2 < 0 || c2 < 0 || r2 >= N || c2 >= N) break;
      if (A[r2][c2] == 1) { A[r2][c2] = 0; ++count; }
    }
  }
  return count;
}