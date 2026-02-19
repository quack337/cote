
function dfs(n) {
  if (n>N) {
    ++C;
    let x = 0;
    for (let i=0; i<N-1; ++i)
      for (let j=i+1; j<N; ++j)
        if (S[i]>S[j]) ++x;
    X += x;
    return;
  }
  for (let i=1; i<=N; ++i)
    if (!V[i]) {
      S.push(i); V[i]=true;
      dfs(n+1);
      S.pop(); V[i]=false;
    } 
}

for (N=1;N<=10;++N) {
  S=[];V=[];X=0;C=0;
  dfs(1);
  console.log("N:%d X:%d C:%d X/C:%f", N, X, C, X/C);
}