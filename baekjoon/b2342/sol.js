let A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
let C=[[0,2,2,2,2],[0,1,3,4,3],[0,3,1,3,4],[0,4,3,1,3],[0,3,4,3,1]];
let M=Array(A.length).fill().map(_=>Array(5).fill().map(_=>Array(5)));
console.log(BT(0,0,0));

function BT(n,a,b) {
  let x=A[n];
  if (x==0) return 0;
  if (M[n][a][b]) return M[n][a][b];
  return M[n][a][b]=Math.min(BT(n+1,x,b)+C[a][x],BT(n+1,a,x)+C[b][x]);
}