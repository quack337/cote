let [N,X,Y] = require('fs').readFileSync(0).toString().trim().split(' ').map(e=>+e),
Z=X-Y-1, V=Array(N+1).fill(2), CNT=0
let S=[]
V[Z]=0;
DFS(0)
console.log(CNT)

function DFS(n) {
  console.log(n, '['+S.join(' ')+']')
  if (n==2*N) {
    ++CNT
    return;
  }
  for (let i=1; i<=N; ++i) {
    if (V[i]==2) {
      S.push(i); V[i]=1; DFS(n+1); S.pop(); V[i]=2
    } else if (V[i]==1 && S[n-i-1] == i) {
      S.push(i); V[i]=0; DFS(n+1); S.pop(); V[i]=1
    }
  }
}