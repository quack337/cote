let D=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
let [N,M]=D, V=[], DP=Array(N).fill().map(_=>[0,0]);
for (let i=0; i<M; ++i)
  V[D[i+2]-1] = true;
console.log(BT(0,0));

function BT(n,prev) { // prev: n-1과 n-2가 swap 되었나?
  if (n==N) return 1;
  if (DP[n][prev]) return DP[n][prev];
  let a = BT(n+1,0); // 제자리 앉기
  let b = (n && !prev && !V[n-1] && !V[n]) ? BT(n+1,1) : 0;
  return DP[n][prev] = a + b;
}