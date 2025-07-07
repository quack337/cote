let A = require('fs').readFileSync(0).toString().trim().split(''),
 N = A.length, S=[], V=[], set = new Set(), 답=0;
DFS();
console.log(set.size, 답);

function DFS() {
  let n = S.length;
  if (n>0 && S[n-2] == S[n-1]) return;
  if (n == N) {
    set.add(S.join('')); ++답;
    return;
  }
  for (let i=0; i < N; ++i) {
    if (!V[i]) {
      S.push(A[i]); V[i]=true;
      DFS();
      S.pop(); V[i]=false;
    }
  }
}