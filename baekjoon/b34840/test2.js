
function dfs(n) {
  if (n>N) {
    ++C;
    for (let i=0; i<N-1; ++i)
      if (S[i]>S[i+1]) ++X;
    return;
  }
  for (let i=1; i<=N; ++i)
    if (!V[i]) {
      S.push(i); V[i]=true;
      dfs(n+1);
      S.pop(); V[i]=false;
    } 
}

for (N=2;N<12;++N) {
  S=[];V=[];X=0;C=0;
  dfs(1);
  console.log(N, X/C);
}