for (let N=1; N<=10; ++N) {
  M=Array(N).fill().map(_=>[1]);
  M[0]=Array(N+1).fill(1);
  for(let n=1; n<N; ++n)
    for(let i=1; i<=N-n; ++i) {
      M[n][i] = 0;
      for (let j=1; j<=i+1; ++j)
        M[n][i] += M[n-1][j];
    }
  console.log(N, M[N-1][1]);
}