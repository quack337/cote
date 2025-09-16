let A=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let N=A.shift()[0];
let M=Array(N).fill().map(_=>[]);
let x = 0;
for (let r=0; r<N; ++r)
  for (let c=0; c<N; ++c)
    x = Math.max(x, DFS(r,c));
console.log(x);

function DFS(r, c) {
  if (M[r][c] != undefined) return M[r][c];
  let h=A[r][c], w=0, x=0, y=0, z=0;
  if (r>0 && A[r-1][c]>h) w = DFS(r-1, c);
  if (c>0 && A[r][c-1]>h) x = DFS(r, c-1);
  if (r<N-1 && A[r+1][c]>h) y = DFS(r+1, c);
  if (c<N-1 && A[r][c+1]>h) z = DFS(r, c+1);
  return M[r][c] = Math.max(w, x, y, z) + 1;
}