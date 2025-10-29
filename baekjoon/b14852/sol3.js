for(N=1; N<=15; ++N){
  A=Array(2).fill().map(_=>[]);
  M=Array(N+1).fill().map(_=>[0,0,0]);
  M[N]=[1];M[N-1]=[2,1,1];
  for(let c=N-2; c>=0; --c){
    M[c][0] = M[c+1][0]*2 + M[c+1][1] + M[c+1][2] + M[c+2][0];
    M[c][1] = M[c+1][0] + M[c+1][2];
    M[c][2] = M[c+1][0] + M[c+1][1];
  }
  console.log(N, M[0][0]);
}
