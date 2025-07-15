let ndx = c=>(c).charCodeAt(0)-'A'.charCodeAt(0),
[X,Y,Z]=require('fs').readFileSync(0).toString().trim().split(' ').map(s=>s.split('').map(c=>ndx(c))),
A=[], S=[], V=[], CNT=0;
[...X, ...Y, ...Z].forEach(i=> A[i]=1)
DFS(0)
console.log(CNT > 0 ? 'YES' : 'NO', CNT)

function DFS(n) {
  if (n==26) {
    let val = p=>p.map(i=>S[i]).reduce((r,e)=>r*10+e, 0)
    let x=val(X), y=val(Y), z=val(Z)
    if (x+y==z) ++CNT
    return
  }
  if (!A[n]) { DFS(n+1); return }
  for (let i=0; i<=9; ++i)
    if (!V[i]) {
      S[n]=i; V[i]=1
      DFS(n+1)
      S[n]=0; V[i]=0
    }
}
