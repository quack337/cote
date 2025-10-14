for (let n=0; n<=20; ++n)
  console.log(n, BT(n));

function BT(n) {
  let r = n;
  for (let i=3; n>i; ++i)
    r = Math.max(r, BT(n-i)*(i-1));
  if (n>3)
    r = Math.max(r, BT(n-3)*2);
  return r;
}