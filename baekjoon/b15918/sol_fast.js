let [N,X,Y]=require('fs').readFileSync(0).toString().trim().split(' ').map(e=>+e),
Z=Y-X-1, V=[], S=[], CNT=0
V[Z]=1; S[X-1]=S[Y-1]=Z
DFS(0)
console.log(CNT)

function DFS(n) {
  while (S[n]) ++n
  if (n==2*N) { ++CNT; return }
  for (let i=1; i<=N; ++i)
    if (!V[i] && !S[n] && !S[n+i+1]) {
      S[n]=S[n+i+1]=i; V[i]=1
      DFS(n+1)
      S[n]=S[n+i+1]=0; V[i]=0
    }
}