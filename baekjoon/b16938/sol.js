let dd = require('fs').readFileSync(0).toString().split('\n'),
 [N,L,R,X] = dd[0].split(' ').map(e=>+e),
 A = dd[1].split(' ').map(e=>+e), 답=0;
 DFS(0,0,0,Infinity,0);
 console.log(답);

function DFS(n,cnt,sum,min,max) {
  if (sum > R) return;
  if (n == N) {
    if (cnt>=2 && sum>=L && max-min >= X) ++답;
    return;
  }
  let a = A[n];
  DFS(n+1, cnt+1, sum+a, a<min?a:min, a>max?a:max);
  DFS(n+1, cnt, sum, min, max);
}
