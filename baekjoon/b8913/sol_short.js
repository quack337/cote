let IN=require('fs').readFileSync(0).toString().split('\n'), T=+IN[0]
for (let t=1; t<=T; ++t) {
  let S=IN[t].split(''), s=0, pch=S[0], A=[{c:pch,n:0}]
  for (let ch of S)
    if (ch==pch) A[s].n++
    else A[++s]={c:pch=ch, n:1}
  console.log(DFS(A))
}

function DFS(A) {
  if (A.length==0) return 1
  for (let i=0; i<A.length; ++i)
    if (A[i].n>1) 
      if (DFS(remove(A,i))) return 1
  return 0
}

function remove(A,i) {
  if (i==0) return A.slice(1)
  else if (i==A.length-1) return A.slice(0,i)
  let x=A[i-1],y=A[i+1],B=A.slice()
  if (x.c!=y.c) B.splice(i,1) 
  else B.splice(i-1, 3, {c:x.c, n:x.n+y.n})
  return B
}