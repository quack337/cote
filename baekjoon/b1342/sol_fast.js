let A0 = require('fs').readFileSync(0).toString().trim().split(''), N=A0.length;
let A = Array(26).fill(0), S=[], 답=0;
A0.forEach(c => A[c.charCodeAt(0) - 'a'.charCodeAt(0)]++);
DFS();
console.log(답);

function DFS() {
  let n = S.length;
  if (n == N) ++답;
  else
  for (let i=0; i < 26; ++i) {
    if (A[i] > 0 && S[n-1] != i) {
      S.push(i); A[i]--;
      DFS();
      S.pop(); A[i]++;
    }
  }
}