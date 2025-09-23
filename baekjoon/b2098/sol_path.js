let IN=require('fs').readFileSync(0).toString().split('\n');
let N=+IN.shift();
let A=IN.map(s=>s.split(' ').map(e=>+e));
let M=Array(N).fill().map(_=>[]);
let ALL = (1<<N) - 1;
// 출발점 0으로 고정
let dist = Infinity, path;
for (let i=1; i<N; ++i) {
  let bit = 1 << i;
  if (A[0][i]) {
    let [d, p] = DFS(i, bit|1);
    d += A[0][i];
    if (d < dist) { dist = d; path = [0, ...p]; }
  }
}
console.log(dist, path);

function DFS(ct, visited) {
  if (visited==ALL)
    return M[ct][visited] = [(A[ct][0] || Infinity), [ct, 0]];
  if (M[ct][visited] != undefined) return M[ct][visited];
  let dist = Infinity, path;
  for (let i=0; i<N; ++i) {
    let bit = 1 << i;
    if ((visited & bit) == 0 && A[ct][i]) {
      let [d, p] = DFS(i, visited|bit);
      d += A[ct][i];
      if (d < dist) { dist = d; path = [ct, ...p]; }
    }
  }
  return M[ct][visited] = [dist, path];
}
