for (let n=1; n<=20; ++n) {
  X=0;
  BT(n,0,0);
  console.log(n, X);
}

function BT(n,a,c) {
  if (n<0) return;
  if (n==0) {
    if (a>X) X=a;
    return;
  }
  BT(n-1, a+1, c);
  BT(n-1, a+c, c);
  BT(n-2, a, a);
}