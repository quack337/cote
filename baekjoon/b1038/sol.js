let dd=require('fs').readFileSync(0).toString().split('\n'),
 N=+dd[0], X=dd[1].split(''), S=[];
let A=Array(N).fill().map(()=>[]), ix=0;
for (let i=0; i<N; ++i)
  for (let j=i; j<N; ++j)
    A[i][j] = X[ix++];
DFS(0);
console.log(S.join(' '));

function DFS(j) {
  if (!valid()) return false;
  if (j==N) return true;
  for (let x=-10; x <= 10; ++x) {
    S.push(x);
    if (DFS(j + 1)) return true;
    S.pop(x);
  }
  return false;
}

function valid() {
  let sum = 0, j = S.length-1;
  for (let i = j; i >= 0; --i) {
    sum += S[i];
    let s= sum<0 ? '-' : (sum>0 ? '+' : '0');
    if (A[i][j] != s) return false;
  }
  return true;
}
