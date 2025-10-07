let D=(require('fs').readFileSync(0)+'').replaceAll('H','0').split('\n');
let [R,C]=D.shift().split(' ').map(e=>+e);
let A=D.map(s=>s.split('').map(e=>+e));
let M=Array(R).fill().map(_=>Array(C));
let x=DFS(0,0,1);
console.log(x==Infinity?-1:x);

function DFS(r,c,n) {
  if (n>R*C){console.log(-1); process.exit(0);}
  if (M[r][c]) return M[r][c];
  let x=A[r][c];
  return M[r][c] = !x ? 0 : 1+Math.max(
    r-x>=0 && DFS(r-x,c,n+1),
    r+x<R && DFS(r+x,c,n+1),
    c-x>=0 && DFS(r,c-x,n+1),
    c+x<C && DFS(r,c+x,n+1));
}
