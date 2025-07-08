let A = require('fs').readFileSync(0).toString().trim();
let N=1, S=[], V=[];
for (let n=0; ; ++N) {
  n += N<10 ? 1 : 2;
  if (n >= A.length) break;
}
DFS(0);

function DFS(i) {
  if (i>=A.length) {
    console.log(S.join(' '));
    process.exit(0);
  }
  for (let j = i+1; j <= A.length; ++j) {
    let x = +A.slice(i, j);
    if (x > N) break;
    if (x > 0 && !V[x]) {
      S.push(x); V[x] = true;
      DFS(j);
      S.pop(); V[x] = false;
    }
  }
}