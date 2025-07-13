let IN=require('fs').readFileSync(0).toString().split('\n'),
N=+IN[0], A=IN.slice(1).map(s=>s.split(' ').map(e=>+e)), S=[], X=Infinity;
DFS(0)
console.log(X)

function DFS(n) {
  if (n==N) {
    if (S.length) {
      let 신=S.reduce((r,e)=>e[0]*r, 1)
      let 쓴=S.reduce((r,e)=>e[1]+r, 0)
      X = Math.min(X, Math.abs(신-쓴))
    }
    return
  }
  S.push(A[n]); DFS(n+1); S.pop(); DFS(n+1)
}
