let A=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let M=[];
let N=A.shift(0)[0];
let OUT=[];
for (let i=0; i<N; ++i)
  OUT.push(DFS(i));
console.log(OUT.join('\n'));

function DFS(n) {
  if (M[n] != undefined) return M[n];
  let B=A[n], mx=0;
  for (let i=1; B[i]!=-1; ++i)
    mx = Math.max(mx, DFS(B[i]-1));
  return M[n] = B[0] + mx;
}