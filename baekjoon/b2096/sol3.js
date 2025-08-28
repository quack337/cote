//  6년전 통과했던 js 답도 이제는 메모리 초과..
// 쓸데 없는 고생만...
let A=require('fs').readFileSync(0).toString().split('\n');
let N=+A[0];
let MNX;
MNX = Math.max; mx = DFS();
MNX = Math.min; mn = DFS();
console.log(mx, mn);

function DFS() {
  let a0,a1,a2,b0,b1,b2,c0,c1,c2;
  [c0,c1,c2] = A[N].split(' ');
  for (i=N-2; i>=0; --i) {
    [a0,a1,a2] = A[i+1].split(' ');
    b0 = +a0 + MNX(c0, c1);
    b1 = +a1 + MNX(c0, c1, c2);
    b2 = +a2 + MNX(c1, c2);
    c0=b0; c1=b1; c2=b2;
  }
  return MNX(b0,b1,b2);
}
