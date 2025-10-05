let A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let [R,C]=A.shift(), M=Array(R).fill().map(_=>Array(C).fill().map(_=>[]));
M[R-1][C-1][0]=M[R-1][C-1][1]=A[R-1][C-1];
console.log(BT(0,0,0));

function BT(r,c,p) {
  if (M[r][c][p]!=undefined) return M[r][c][p];
  return M[r][c][p]=Math.max(
    r<R-1 ? BT(r+1,c,0) :-Infinity,
    c>0 && p!=1 ? BT(r,c-1,2) :-Infinity,
    c<C-1 && p!=2 ? BT(r,c+1,1) :-Infinity) + A[r][c];
}
