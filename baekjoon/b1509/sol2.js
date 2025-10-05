let S=(require('fs').readFileSync(0)+'').trim().split('');
let N=S.length;
let P=Array(N).fill().map(_=>Array(N));
let B=Array(N).fill().map(_=>Array(N));
for (let i=0; i<N; ++i) P[i][i]=B[i][i]=1;
console.log(BT(0,N-1));

function PAL(a,b) {
  if (P[a][b]!=undefined) return P[a][b];
  return P[a][b] = S[a]==S[b] && (a+1==b || PAL(a+1,b-1));
}
function BT(a,b) {
  if (B[a][b]!=undefined) return B[a][b];
  if (PAL(a,b)) return B[a][b]=1;
  let x = Infinity;
  for (let i=a; i<b; ++i)
    if (PAL(a,i))
      x = Math.min(x, 1 + BT(i+1, b));
  return B[a][b]=x;
}
