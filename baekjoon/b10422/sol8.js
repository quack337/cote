for (let N=1; N<=10; ++N) {
  M=Array(N).fill().map(_=>[]);
  M[0]=Array(N+1).fill(1);
  for(let n=1; n<N; ++n){
    M[n][1] = M[n-1][2]+M[n-1][1];
    for(let i=2; i<=N-n; ++i)
      M[n][i] = M[n][i-1]+M[n-1][i+1];
  }
  console.log(N, M[N-1][1]);
}