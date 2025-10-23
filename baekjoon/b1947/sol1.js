for (N=2; N<=6; ++N) {
  S=[]; T=[];
  console.log(N, BT(0));
}

function BT(n) {
  if (n==N) {
    console.log(T);
    return 1;
  }
  let r=0;
  for(let i=0; i<N; ++i)
    if(!S[i] && i!=n) {
      S[i]=1; T.push(i); r += BT(n+1); S[i]=0; T.pop();
    }
  return r;
}