D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];M=D[2][0];
P=Array(N).fill().map(_=>Array(M+1).fill().map(_=>[]));
BT=(n,m,z)=>{
  if (n<0) return '';
  if (P[n][m][z]!=undefined) return P[n][m][z];
  let x1, x2 = -Infinity;
  for (let i=0, s=''; A[n]*i<=m; ++i,s+=n) {
    let t1 = s + BT(n-1, m-A[n]*i, z||i);
    let t2 = BigInt((z?'1':'0') + t1);
    if (t2 > x2) { x1 = t1; x2 = t2; }
  }
  return P[n][m][z] = x1;
}
x=BT(N-1,M,0)
console.log(x.trim().length?x:'0');