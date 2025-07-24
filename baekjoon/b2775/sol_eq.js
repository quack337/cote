let A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e),
T=A.shift(), OUT=[], M=Array(15).fill().map(_=>[])
for (let i=0; i<=14; ++i) {
  M[0][i] = i;
  M[i][0] = 0;
}
for (let 층=1; 층<=14; ++층)
  for (let 호=1; 호<=14; ++호)
    M[층][호] = M[층][호-1] + M[층-1][호];
for (let t=0; t<T; ++t) {
  let 층 = A[t*2], 호 = A[t*2+1]
  OUT.push(M[층][호])
}
console.log(OUT.join('\n'))