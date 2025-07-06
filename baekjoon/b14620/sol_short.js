let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let N = +data[idx++];
let A = Array(N).fill().map(() => []);
for (let r = 0; r < N; ++r)
for (let c = 0; c < N; ++c)
  A[r][c] = +data[idx++];
let set = [], 답 = Infinity;
const D=[[0,0],[-1,0],[0,1],[1,0],[0,-1]];
DFS(0, N*N - 3);
console.log(답);

function DFS(from, to) {
  if (set.length == 3)
    답 = Math.min(답, cost());
  else
    for (let i = from; i <= to; ++i) {
      set.push(i);
      DFS(i+1, to+1);
      set.pop();
    }
}

function cost() {
  let V = [], sum = 0;
  for (let i of set) {
    let c0 = i % N, r0 = (i-c0) / N;
    if (r0==0 || c0==0 || r0==N-1 || c0==N-1)
      return Infinity;
    for (let [dr, dc] of D) {
      let r = r0 + dr, c = c0 + dc;
      if (V[r*N+c]) return Infinity;
      V[r*N+c] = true;
      sum += A[r][c];
    }
  }
  return sum;
}