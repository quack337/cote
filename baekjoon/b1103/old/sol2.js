// 시간초과
let D=(require('fs').readFileSync(0)+'').replaceAll('H','0').split('\n');
let [R,C]=D.shift().split(' ').map(e=>+e);
let A=D.map(s=>s.split('').map(e=>+e));
console.log(DFS(0,0,0)+1);

function DFS(r,c,n) {
  if (n>=R*C) {console.log(-1);process.exit(0);}
  let x=A[r][c];
  return !x ? 0 : Math.max(
    r-x>=0 && A[r-x][c] ? DFS(r-x,c,n+1)+1 :0,
    r+x<R && A[r+x][c] ? DFS(r+x,c,n+1)+1 :0,
    c-x>=0 && A[r][c-x] ? DFS(r,c-x,n+1)+1 :0,
    c+x<C && A[r][c+x] ? DFS(r,c+x,n+1)+1 :0);
}
