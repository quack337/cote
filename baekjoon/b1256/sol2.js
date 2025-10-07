let N=200;
let M=Array(N).fill().map((_,i)=>Array(i+1).fill(1n));
for (let r=2; r<N; ++r)
  for (let c=1; c<r; ++c)
    M[r][c] = M[r-1][c-1] + M[r-1][c];
