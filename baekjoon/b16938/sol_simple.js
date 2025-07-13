let data = require('fs').readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = ()=>parseInt(data[idx++]);
let N = getInt(), L = getInt(), R = getInt(), X = getInt();
let A = [], 답=0, selected=[];
for (let i = 0; i < N; ++i)
  A[i] = getInt();
 DFS(0);
 console.log(답);

function DFS(index) {
  if (index == N) {
    if (selected.length >= 2) {
      let sum=0, min=Infinity, max=0;
      for (let val of selected) {
        sum += val;
        if (val < min) min = val;
        if (val > max) max = val;
      }
      if (sum >= L && sum <= R && max-min >= X) ++답;
    }
    return;
  }
  selected.push(A[index]);
  DFS(index+1);
  selected.pop();
  DFS(index+1);
}
