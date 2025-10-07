let [A,B,C]=(require('fs').readFileSync(0)+'').split(/\s/).map(s=>s.split(''));
let AN=A.length, BN=B.length, CN=C.length;
let M=Array(AN+1).fill().map(_=>Array(BN+1).fill().map(_=>Array(CN+1)));
console.log(BT(0,0,0));

function BT(a,b,c) {
  if (M[a][b][c]!=undefined) return M[a][b][c];
  if (a==AN || b==BN || c==CN) return M[a][b][c]=0;
  return M[a][b][c] = Math.max(
    A[a]==B[b] && B[b]==C[c] && BT(a+1,b+1,c+1)+1,
    BT(a+1, b, c), BT(a, b+1, c), BT(a, b, c+1));
}
