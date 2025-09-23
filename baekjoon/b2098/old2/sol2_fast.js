let IN=require('fs').readFileSync(0).toString().split('\n');
let N=+IN.shift();
let A=IN.map(s=>s.split(' ').map(e=>+e));
let M=Array(N).fill().map(_=>Array(N).fill().map(_=>[]));
let ALL = (1<<N) - 1;
let dist = Infinity, path;
for (let i=0; i<N; ++i) {
  let bit = 1 << i;
  let d = DFS(i, i, bit);
  if (d < dist) dist = d;
}
console.log(dist);

function DFS(ct0, ct, visited) {
  if (visited==ALL)
    return M[ct0][ct][visited] = (A[ct][ct0] || Infinity);
  if (M[ct0][ct][visited] != undefined) 
    return M[ct0][ct][visited];
  let dist = Infinity;
  for (let i=0; i<N; ++i) {
    let bit = 1 << i;
    if ((visited & bit) == 0 && A[ct][i]) {
      let d = DFS(ct0, i, visited | bit) + A[ct][i];
      if (d < dist) dist = d;
    }
  }
  return M[ct0][ct][visited] = dist;
}
