// 패턴을 찾아보려고 했지만 실패
for (N=4; N<=9; ++N) {
  let OUT=[]
  for (K=0; K<=N; ++K) {
    S=[];
    OUT.push(BT(0,K));
  }
  console.log(OUT.join(' '));
}

function BT(n,k) {
  if (k==0) return 1;
  if (n>=N) return 0;
  let x = BT(n+1,k);
  if (n==0 || (!S[n-1] && (n<N-1 || !S[0]))) {
    S[n] = 1;
    x += BT(n+1,k-1);
    S[n] = 0;
  }
  return x;
}
