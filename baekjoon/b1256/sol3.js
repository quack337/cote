N=200;
C=Array(N+1).fill().map((_,i)=>Array(i+1).fill(1n));
for (let r=2; r<=N; ++r)
  for (let c=1; c<r; ++c)
    C[r][c] = C[r-1][c-1] + C[r-1][c];

[n,m,k]=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
k = BigInt(k);
if (k > C[m+n][n]) {
  console.log(-1);
  return;
}
X='';
while (n+m) {
  if (!n) {X+='z'; --m;}
  else if (!m) {X+='a'; --n;}
  else {
    nCr = C[n-1+m][m];
    if (k <= nCr) {X+='a'; --n;}
    else {X+='z'; --m; k-=nCr;}
  }
}
console.log(X);