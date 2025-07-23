N=+(require('fs').readFileSync(0)+'').trim()
S=[]
X=[]
BT=(a,m)=>{
 if (a+m==N+N) {
  let A=[],B=[],x=1
  for (let i=0;i<N+N;++i)
   if (S[i]) A.push(x++); else B.push(A.pop())
  X.push(B.join(' '))
  return
 }
 if (m<N&&a>m) {S[a+m]=0; BT(a,m+1)}
 if (a<N) {S[a+m]=1; BT(a+1,m)}
}
BT(0,0)
console.log(X.join('\n'))