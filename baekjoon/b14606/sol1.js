for(N=1; N<=10; ++N) {
  console.log(N, BT(N));
}

function BT(n) {
  let x=0;
  for (let i=1; i<=n/2; ++i)
    x = Math.max(x, BT(i) + BT(n-i) + i*(n-i));
  return x;
}