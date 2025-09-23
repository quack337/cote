// 출발한 곳으로 돌아오지 않는 경우
let IN=require('fs').readFileSync(0).toString().split('\n');
let N=+IN.shift();
let A=IN.map(s=>s.split(' ').map(e=>+e));
let M=Array(N).fill().map(_=>[]);
let ALL = (1<<N) - 1;
let dist = Infinity, path;
for (let i=0; i<N; ++i) {
  let bit = 1 << i;
  let [d, p] = DFS(i, bit);
  if (d < dist) { dist = d; path = p; }
}
console.log(dist, path);

function DFS(city, visited) {
  if (visited==ALL) return M[city][visited] = [0, [city]];
  if (M[city][visited] != undefined) return M[city][visited];
  let dist = Infinity, path;
  for (let i=0; i<N; ++i) {
    let bit = 1 << i;
    if ((visited & bit) == 0 && A[city][i]) {
      let [d, p] = DFS(i, visited | bit);
      d += A[city][i];
      if (d < dist) { dist = d; path = [city, ...p]; }
    }
  }
  return M[city][visited] = [dist, path];
}
