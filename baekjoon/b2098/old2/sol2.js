// 동적 프로그래밍 효율이 나뻐서 느리다
let IN=require('fs').readFileSync(0).toString().split('\n');
let N=+IN.shift();
let A=IN.map(s=>s.split(' ').map(e=>+e));
let M=Array(N).fill().map(_=>Array(N).fill().map(_=>[]));
let ALL = (1<<N) - 1;
let dist = Infinity, path;
for (let i=0; i<N; ++i) {
  let bit = 1 << i;
  let [d, p] = DFS(i, i, bit);
  if (d < dist) { dist = d; path = p; }
}
console.log(dist, path);

function DFS(ct0, ct, visited) {
  if (visited==ALL)
    return M[ct0][ct][visited] = [A[ct][ct0] || Infinity, [ct, ct0]];
  if (M[ct0][ct][visited] != undefined) 
    return M[ct0][ct][visited];
  let dist = Infinity, path;
  for (let i=0; i<N; ++i) {
    let bit = 1 << i;
    if ((visited & bit) == 0 && A[ct][i]) {
      let [d, p] = DFS(ct0, i, visited | bit);
      d += A[ct][i];
      if (d < dist) { dist = d; path = [ct, ...p]; }
    }
  }
  return M[ct0][ct][visited] = [dist, path];
}
