// 답
let dd=require('fs').readFileSync(0).toString().split('\n'),
 N=+dd[0], X=dd[1].split(''), B=Array(N).fill(0), S=[];
let A=Array(N).fill().map(()=>[]), ix=0;
for (let i=0; i<N; ++i)
  for (let j=i; j<N; ++j)
    A[i][j] = X[ix++];
DFS(0);
console.log(S.join(' '));

function DFS(j) {
  if (j==N) return true;
  for (let x=-10; x <= 10; ++x)
    if (valid(j, x)) {
      S.push(x); addB(j, x);
      if (DFS(j + 1)) return true;
      S.pop(x); addB(j, -x);
    }
  return false;
}

function valid(j, x) {
  for (let i = 0; i <= j; ++i) {
    let t= B[i]+x, s= t<0 ? '-' : (t>0 ? '+' : '0');
    if (A[i][j] != s) return false;
  }
  return true;
}

function addB(j, x) {
  for (let i = 0; i <= j; ++i)
    B[i] += x;
}