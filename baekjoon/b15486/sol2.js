// 점화식을 만들기 위해서...
let A=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let N=A.shift()[0];
let M=[];
console.log(DFS(0));

function DFS(n) {
  if (n==N) return 0;
  if (M[n] != undefined) return M[n];
  let [t,p] = A[n];
  return M[n] = Math.max(n+t>N ? 0 : DFS(n+t)+p, DFS(n+1));
}