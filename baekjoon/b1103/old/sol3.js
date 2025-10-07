//시간초과
let D=(require('fs').readFileSync(0)+'').replaceAll('H','0').split('\n');
let [R,C]=D.shift().split(' ').map(e=>+e);
let A=D.map(s=>s.split('').map(e=>+e));
let V=Array(R).fill().map(_=>Array(C));
console.log(DFS(0,0));

function DFS(r,c) {
  // console.log(r,c);
  if (V[r][c]){console.log(-1);process.exit(0);}
  V[r][c]=1;
  let x=A[r][c];
  let d= !x ? 1 : Math.max(
    r-x>=0 && A[r-x][c] ? DFS(r-x,c)+1 :1,
    r+x<R && A[r+x][c] ? DFS(r+x,c)+1 :1,
    c-x>=0 && A[r][c-x] ? DFS(r,c-x)+1 :1,
    c+x<C && A[r][c+x] ? DFS(r,c+x)+1 :1);
  V[r][c]=0;
  return d;
}
