[N,K]=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
M=Array(N).fill().map(_=>Array(K+1).fill().map(_=>[]));
D=1_000_000_003;
console.log(BT(0,K,0,0));

function BT(n,k,p,s) {
  if (k==0) return 1;
  if (n>=N) return 0;
  if (M[n][k-1][p*2+s]!=undefined) return M[n][k-1][p*2+s];
  let x;
  if (n==0)
    x = (BT(1,k-1,1,1)%D + BT(1,k,0,0)%D)%D;
  else {
    x = BT(n+1,k,0,s);
    if (n==0 || (!p && (n<N-1 || !s)))
      x = (x + BT(n+1,k-1,1,s))%D;
  }
  return M[n][k-1][p*2+s] = x;
}
