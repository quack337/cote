let A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>e-1); // 1,2를 0,1로 수정
let [T,W]=A.splice(0,2);++T;++W;
let M=Array(T).fill().map(_=>Array(W+1).fill().map(_=>[-1,-1]));
console.log(Math.max(BT(0,W,0), BT(0,W-1,1)));

function BT(t,w,i) {
  if (t==T) return 0;
  if (M[t][w][i]>-1) return M[t][w][i];
  return M[t][w][i]=Math.max(BT(t+1,w,i), w?BT(t+1,w-1,i?0:1):0) + (A[t]==i?1:0);
}
