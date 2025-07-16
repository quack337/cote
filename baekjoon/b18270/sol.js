let NM=['Beatrice','Belinda','Bella','Bessie','Betsy','Blue','Buttercup','Sue'],
IN=require('fs').readFileSync(0).toString().split('\n'),
RULE=[], V=[], nmMap=new Map(), X=[]

NM.forEach((s,i)=>nmMap.set(s,i))
RULE=IN.slice(1).map(s=> { let a=s.split(' '); return [nmMap.get(a[0]), nmMap.get(a.pop())] })
DFS(0)
console.log(X.join('\n'))

function DFS(n) {
  if (n==8) {
    V.forEach((o,i)=> X[o-1] = NM[i])
    return 1
  }
  for (let i=0; i<8; ++i)
    if (!V[i]) {
      V[i]=n+1
      if (valid() && DFS(n+1)) return 1
      V[i]=0
    }
}

function valid() {
  for (let [a,b] of RULE)
    if (V[a] && V[b] && Math.abs(V[a]-V[b])>1) return 0
  return 1
}