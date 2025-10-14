N=+(require('fs').readFileSync(0)+'').trim();
M=Array(N+1);
console.log(BT(N));

function BT(n) {
  if (M[n]) return M[n];
  let r = n;
  for (let i=3; n>i; ++i)
    r = Math.max(r, BT(n-i)*(i-1));
  if (n>3)
    r = Math.max(r, BT(n-3)*2);
  return M[n]=r;
}