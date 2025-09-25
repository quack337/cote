// stack overflow
let A=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let N=A.shift()[0];
let M=[];
console.log(DFS(0));

function DFS(n) {
  if (n==N) return 0;
  if (M[n] != undefined) return M[n];
  let a=0, b=0;
  if (A[n][0] + n <= N)
    a = A[n][1] + DFS(n + A[n][0]);
  b = DFS(n + 1);
  return M[n] = Math.max(a, b);
}