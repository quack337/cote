let AD=0, MI=1, MU=2, DI=3,
IN = require('fs').readFileSync(0).toString().split('\n'),
N=+IN[0], A=IN[1].split(' ').map(e=>+e), 
OP=IN[2].split(' ').map((e,i)=>Array(+e).fill(i)).flat(), V=[], S=[], 
MAX=-Infinity, MIN=Infinity
DFS()
console.log(MAX + '\n' + MIN)

function DFS() {
  if (S.length==N-1) {
    let val = calc()
    if (val > MAX) MAX=val
    if (val < MIN) MIN=val
    return
  }
  for (let i=0; i < N-1; ++i) 
    if (!V[i]) {
      S.push(OP[i]); V[i]=1
      DFS()
      S.pop(); V[i]=0
    }
}

function calc() {
  let B=[A[0]], S2=[]
  for (let i=0; i < S.length; ++i)
    if (S[i]==2)
      B.push(B.pop() * A[i+1])
    else if (S[i]==3)
      B.push(Math.floor(B.pop() / A[i+1]))
    else {
      B.push(A[i+1])
      S2.push(S[i])
    }
  let r=B[0];
  for (let i=0; i < S2.length; ++i)
    r += S2[i] ? -B[i+1] : B[i+1] 
  return r
}