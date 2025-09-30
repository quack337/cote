let A=require('fs').readFileSync(0).toString().trim().split('').map(e=>+e);
let N=A.length, M=[];
console.log(DFS(0));

function DFS(n) {
  if (n==N) return 1;
  if (M[n]!=undefined) return M[n];
  let sum = 0;
  if (A[n]>0) sum += DFS(n+1);
  if (n<N-1) {
    let x = A[n]*10+A[n+1];
    if (x>9 && x<=26) sum += DFS(n+2);
  }
  return M[n] = sum % 1000000;
}