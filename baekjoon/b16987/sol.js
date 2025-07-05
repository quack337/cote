let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), ix = 0;
let N = +data[ix++], E = [];
for (let i = 0; i < N; ++i)
  E[i] = {s: +data[ix++], w: +data[ix++]};
let 답 = 0;
DFS(0);
console.log(답);

function DFS(i) {
  if (i == N)
    답 = Math.max(답, E.reduce((r, e) => e.s <= 0 ? r+1 : r, 0));
  else {
    let a = E[i], hit = 0;
    if (a.s > 0)
      for (let j = 0; j < N; ++j) {
        let b = E[j];
        if (a != b && b.s > 0) {
          hit = 1;
          b.s -= a.w; a.s -= b.w;
          DFS(i+1);
          b.s += a.w; a.s += b.w;
        };
      }
    if (!hit) DFS(i+1);
  }
}