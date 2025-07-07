let A = require('fs').readFileSync(0).toString().trim().split('');
let s = '', N, S=[], V=[];
for (N = 1; s.length < A.length; ++N)
  s += N;
DFS(0);
console.log(S.join(' '));

function DFS(i) {
  if (i>=A.length) return true;
  for (let j = i+1; j <= A.length; ++j) {
    let x = Number(A.slice(i, j).join(''));
    if (x > N) break;
    if (x > 0 && !V[x]) {
      S.push(x); V[x] = true;
      if (DFS(j)) return true;
      S.pop(); V[x] = false;
    }
  }
  return false;
}


