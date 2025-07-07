let D = require('fs').readFileSync(0).toString().split(/[\n\r]+/),
 W=D.splice(1), A, N, S=[], OUT=[], ACODE='a'.charCodeAt(0);
for (let w of W) {
  A = Array(26).fill(0);
  N = w.length;
  for (let ch of w.split(''))
    A[ch.charCodeAt(0)-ACODE]++;
  DFS(0);
}
console.log(OUT.join('\n'));

function DFS(n) {
  if (n==N) OUT.push(S.join(''));
  else
  for (let i=0; i<26; ++i)
    if (A[i] > 0) {
      A[i]--; S.push(String.fromCharCode(i+ACODE));
      DFS(n+1);
      A[i]++; S.pop();
    }
}