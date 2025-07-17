let IN=require('fs').readFileSync(0).toString().split('\n'), T=+IN[0]
for (let t=1; t<=T; ++t) {
  let S=IN[t].split(''), s=0, pch=S[0], A=[[pch,0]]
  for (let ch of S)
    if (ch==pch) A[s][1]++
    else A[++s]=[pch=ch,1]
  console.log(DFS(A))
}

function DFS(A) {
  if (A.length==0) return 1
  for (let i=0; i<A.length; ++i)
    if (A[i][1]>1) 
      if (DFS(remove(A,i))) return 1
  return 0
}

function remove(A,i) {
  if (i==0) return A.slice(1)
  else if (i==A.length-1) return A.slice(0,i)
  else if (A[i-1][0]!=A[i+1][0]) return A.slice().splice(i, 1)
  let B=A.slice(); B.splice(i-1, 3, [A[i-1][0], A[i-1][1]+A[i+1][1]])
  return B
}