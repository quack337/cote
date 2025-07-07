// 답!
let D = require('fs').readFileSync(0).toString().split('\n'),
 N = +D[0], C= D[1].split(' ').map(e=>+e),
 A = D.slice(2).map(e=>e.split(' ').map(e=>+e)),
 P = Infinity, Q;
DFS(0)
console.log(Q ? P+'\n' + Q.map(e => e+1).join(' ') : '-1\n');

function DFS() {
  let stack = [[0, []]]
  while (stack.length > 0) {
    let [n,S]=stack.pop()
    if (n==N) {
      let B = S.reduce((r,s) => A[s].map((a,i) => a+r[i]), [0,0,0,0,0]);
      if (B.slice(0,4).every((e,i) => e>=C[i]))
        if (B[4] < P) {
          P = B[4]; Q = S;
        } else if (B[4]==P && S.every((e,i)=> e<=Q[i]) && S.length<=Q.length)
          Q = S;
    } else {
      stack.push([n+1, S]);
      stack.push([n+1, [...S, n]]);
    }
  }
}
