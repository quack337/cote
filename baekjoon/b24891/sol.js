// 틀릴 이유가 없는데 틀려서, 그냥 평범하게 java로 구현하니 성공함.
// 뭐가 문제일까...
IN=(require('fs').readFileSync(0)+'').split('\n')
t=IN[0].trim().split(/[ \t]+/)
L=parseInt(t[0])
N=parseInt(t[1])
A=IN.slice(1).sort().map(s=>s.split(''))
S=[]
V=[]
X='NONE'
VD=_=>{
  for (let i=1; i<L; ++i)
    for (let j=0; j<i; ++j)
      if (S[i][j]!=S[j][i]) return 0
  return 1
}
BT=n=>{
  if(n==L) {
    if (!VD()) return 0
    X=S.map(e=>e.join('')).join('\n')
    return 1
  }
  for (let i=0; i<N; ++i)
    if (!V[i]) {
      V[i]=1; S[n]=A[i]
      if (BT(n+1)) return 1
      V[i]=0;
    }
}
BT(0)
console.log(X)