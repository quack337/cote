// bottom up
// 흠.. 느림...
let N = +require('fs').readFileSync(0).toString();
let M = Array(N+1).fill(Infinity);
DFS(0,0);
console.log(M[N]);

function DFS(from, count) {
  if (count >= M[N]) return;
  let e = Math.floor(Math.sqrt(N-from));
  for (let i=e; i>0; --i) {
    let j = i*i + from;
    M[j] = Math.min(M[j], count+1);
    DFS(j, count + 1);    
  }
}