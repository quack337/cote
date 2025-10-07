// 시간초과
let D=(require('fs').readFileSync(0)+'').replaceAll('H','0').split('\n');
let [R,C]=D.shift().split(' ').map(e=>+e);
let A=D.map(s=>s.split('').map(e=>+e));
let x=DFS(0,0,0);
console.log(x==Infinity?-1:x+1);

function DFS(r,c,cnt) {
  // console.log(r,c,cnt);
  if (cnt>=R*C) return Infinity;
  let n=A[r][c];
  return !n ? 0 : Math.max(
    r-n>=0 && A[r-n][c] ? DFS(r-n,c,cnt+1)+1 :0,
    r+n<R && A[r+n][c] ? DFS(r+n,c,cnt+1)+1 :0,
    c-n>=0 && A[r][c-n] ? DFS(r,c-n,cnt+1)+1 :0,
    c+n<C && A[r][c+n] ? DFS(r,c+n,cnt+1)+1 :0);
}
