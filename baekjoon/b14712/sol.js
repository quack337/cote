// 백트레킹 구현. R C 가 커지면 시간 초과.
let [R,C] = require('fs').readFileSync(0).toString().trim().split(' ').map(e=>+e);
let A = Array(R).fill().map(_=>Array(C).fill(0)), CNT=0;
DFS(0,0);
console.log(CNT);

function DFS(r, c) {
  if (c >= C) {
    c = 0;
    if (++r >= R) {
      ++CNT;
      // let ss = ['.','#'];
      // for (let row of A)
      //   console.log(row.map(e=>ss[e]).join(''));
      // console.log();
      return;
    }
  }
  A[r][c] = 1;
  if (valid(r, c)) DFS(r, c+1);
  A[r][c] = 0;
  DFS(r, c+1);
}

function valid(r, c) {
  if (r>0 && c>0 && A[r-1][c-1]+A[r-1][c]+A[r][c-1]==3) return false;
  if (r>0 && A[r-1][c]+A[r-1][c+1]+A[r][c+1]==3) return false;
  return true;
}