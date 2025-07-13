let input = require('fs').readFileSync(0).toString().split(/[ \n\r]+/), idx=0;
let getInt = ()=>parseInt(input[idx++]);
let N=getInt(), A=[], selected=[], 답=Infinity;
for (let i = 0; i < N; ++i) {
  A[i] = [];
  A[i][0] = getInt();
  A[i][1] = getInt();
}
DFS(0);
console.log(답);

function DFS(index) {
  if (index == N) {
    if (selected.length > 0) {
      let 신 = selected.reduce((r, e) => e[0] * r, 1);
      let 쓴 = selected.reduce((r, e) => e[1] + r, 0);
      답 = Math.min(답, Math.abs(신 - 쓴));
    }
    return;
  }
  selected.push(A[index]);
  DFS(index + 1);
  selected.pop(index);
  DFS(index + 1);
}
