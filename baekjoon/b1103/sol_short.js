D=(require('fs').readFileSync(0)+'').replaceAll('H','0').split('\n');
[R,C]=D.shift().split(' ').map(e=>+e);
A=D.map(s=>s.split('').map(e=>+e));
M=Array(R).fill().map(_=>Array(C));
console.log(BT(0,0,1));

function BT(r,c,n) {
  if (n>R*C){console.log(-1);process.exit(0);}
  if (M[r][c]) return M[r][c];
  let x=A[r][c];
  return M[r][c]= !x ? 0: 1+Math.max(
    r-x>=0 && BT(r-x,c,n+1), r+x<R && BT(r+x,c,n+1),
    c-x>=0 && BT(r,c-x,n+1), c+x<C && BT(r,c+x,n+1));
}
