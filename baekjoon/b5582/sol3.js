let [A,B]=(require('fs').readFileSync(0)+'').split('\n');
let AL=A.length, BL=B.length
let P1 = Array(AL).fill().map(e=>Array(BL).fill(-1));
let P2 = Array(AL).fill().map(e=>Array(BL).fill(-1));
console.log(F2(0,0))

function F1(i, j) {
  if (i==AL || j==BL) return 0;
  if (P1[i][j]>-1) return P1[i][j];
  return P1[i][j] = A[i] != B[j] ? 0 : F1(i+1, j+1) + 1;
}

function F2(i, j) {
  if (i==AL || j==BL) return 0;
  if (P2[i][j]>-1) return P2[i][j];
  return P2[i][j] = Math.max(F2(i,j+1), F2(i+1,j), A[i]==B[j] ? F1(i,j) : 0);
}
