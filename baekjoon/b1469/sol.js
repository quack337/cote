let IN=require('fs').readFileSync(0).toString().split('\n'),
N=+IN[0], A=IN[1].split(' ').map(e=>+e),
V=[], S=Array(2*N).fill(-1)
A.sort((a,b)=>a-b)
console.log(DFS(0) ? S.join(' ') : -1)

function DFS(n) {
  if (n==2*N) return 1
  if (S[n]!=-1) return DFS(n+1)
  for (let i=0; i<N; ++i) {
    let x=A[i]
    if (!V[i] && n+x+1<S.length && S[n]==-1 && S[n+x+1]==-1) {
      S[n]=S[n+x+1]=x; V[i]=1
      if (DFS(n+1)) return 1
      S[n]=S[n+x+1]=-1; V[i]=0
    }
  }
}