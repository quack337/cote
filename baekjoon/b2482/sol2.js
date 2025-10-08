for (N=4; N<9; ++N) {
  let OUT=[]
  for (K=0; K<=N; ++K) {
    S=[];
    OUT.push(BT(0,K,0,0));
  }
  console.log(OUT.join(' '));
}

function BT(n,k,p,s) {
  if (k==0) return 1;
  if (n>=N) return 0;
  let x;
  if (n==0)
    x = BT(1,k-1,1,1) + BT(1,k,0,0);
  else {
    x = BT(n+1,k,0,s);
    if (n==0 || (!p && (n<N-1 || !s)))
      x += BT(n+1,k-1,1,s);
  }
  return x;
}
