// 시간초과
let IN = require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e));
let T = IN[0][0], N, A, SIZE, COST, X=[];
for (let t=0; t<T; ++t) {
  N=IN[t*2+1][0];
  A=IN[t*2+2];
  SIZE=Array(N).fill().map(_=>[]);
  COST=Array(N).fill().map(_=>[]);
  let [cost] = DFS(0,N-1);
  X.push(cost);
}
console.log(X.join('\n'));

function DFS() {
  for (let i=0; i<N; ++i) {
    COST[i][i] = 0;
    SIZE[i][i] = A[i];
  }
  // 점화식 구현중
  
    M[i][i] = [0, A[from]];

  if (M[from][to]) return M[from][to];
  let min = [Infinity, 0];
  for (let i=from; i<to; ++i) {
    let [cost1, size1] = DFS(from, i);
    let [cost2, size2] = DFS(i+1, to);
    let size3 = size1 + size2;
    let cost3 = cost1 + cost2 + size3;
    if (cost3 < min[0]) min = [cost3, size3];
  }
  return M[from][to] = min;
}