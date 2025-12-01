D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];
BT=n=>{
  if(n==N-1) return 0;
  let x=0, y=0;
  for(let i=n+1; i<N; ++i) {
    if(A[n] > A[i]) {
      [A[n],A[i]] = [A[i], A[n]];
      x += BT(n) + 1;
      [A[i],A[n]] = [A[n], A[i]];
      ++y;
    }
  }
  return y ? x/y : BT(n+1);
}
console.log(BT(0))