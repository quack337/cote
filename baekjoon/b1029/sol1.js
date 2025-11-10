D=(require('fs').readFileSync(0)+'').split('\n');
N=+D.shift();
A=D.map(s=>s.split('').map(e=>+e));
M=Array(N).fill().map(_=>Array(10).fill().map(_=>[]));
BT=(n,price,bit) => {
  let m=M[n][price];if(m[bit]!=undefined)return m[bit];
  let x = 0;
  for (let i=0; i<N; ++i)
    if (!((1<<i)&bit) && A[n][i] >= price)
      x = Math.max(x, BT(i, A[n][i], bit|(1<<i)));
  return m[bit] = x + 1;
}
console.log(BT(0,0,1))