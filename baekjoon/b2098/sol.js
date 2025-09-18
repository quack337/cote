let IN=require('fs').readFileSync(0).toString().split('\n');
let N=+IN.shift();
let A=IN.map(s=>s.split(' ').map(e=>+e));
let M=Array(N+1).fill().map(_=>[]);
let ALL = (1<<N) - 1;
let distance = Infinity;
for (let i=0; i<N; ++i) {
  let bit = 1 << i;
  distance = Math.min(distance, DFS(i, bit));
}
console.log(distance);
DFS2(1, distance, []);

function DFS(city, visited) {
  if (visited==ALL) return M[city][visited] = 0;
  //if (M[prev][visited] != undefined) return M[prev][visited];
  let distance = Infinity;
  for (let i=0; i<N; ++i) {
    let bit = 1 << i;
    if ((visited & bit) == 0 && A[city][i])
      distance = Math.min(distance, DFS(i, visited | bit) + A[city][i]);
  }
  return M[city][visited] = distance;
}

function DFS2(count, distance, S) {
  if (count == N) console.log(S);
  for (let i=0; i<N; ++i)
    for (let v=0; v<=ALL; ++v) {
      if (bitCount(v) != count) continue;
      if (M[i][v] == distance) {
        for (let j=0; j<N; ++j) {
          if (S.includes(j)) continue;
          if (A[i][j] == 0) continue;
          DFS2(count + 1, distance - A[i][j], [...S, j]);
        }
      }
    }
}

function bitCount(visited) {
  let count = 0;
  for (let i=0; i < N; ++i) {
    let bit = 1 << i;
    if (visited & bit) ++count;
  }
  return count;
}