let D = require('fs').readFileSync(0).toString().split('\n'),
 T = +D[0], A = D.slice(1).map(e=> e.split(' ').map(e=>+e)), V=[], 답=0, R=[];
for (let t=0; t<T; ++t) {
  답 = 0;
  DFS(0,0);
  R.push(답);
  A = A.slice(11);
}
console.log(R.join('\n'));

function DFS(n, sum) {
  if (n==11) 답 = Math.max(답, sum);
  else
  for (let i = 0; i < 11; ++i)
    if (!V[i] && A[i][n] > 0) {
      V[i] = true;
      DFS(n+1, sum + A[i][n]);
      V[i] = false;
    }
}