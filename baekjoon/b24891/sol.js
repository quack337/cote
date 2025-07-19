IN=(require('fs').readFileSync(0)+'').split('\n')
t=IN[0].trim().split(' ')
L=+t[0]
N=+t[1]
A=IN.slice(1,N+1).sort().map(s=>s.trim().split(''))
S=[]
V=[]
X='NONE'
BT=n=>{
 for (let i=1; i<n; ++i)
  for (let j=0; j<i; ++j)
    if (S[i][j]!=S[j][i]) return 0
 if(n==L) {
   X=S.map(e=>e.join('')).join('\n')
   return 1
 }
 for (let i=0; i<N; ++i)
   if (!V[i]) {V[i]=1; S[n]=A[i]; if(BT(n+1)) return 1; V[i]=0;}
}
BT(0)
console.log(X)