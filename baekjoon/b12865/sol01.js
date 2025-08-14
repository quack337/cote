D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
let[N,W]=D.shift()
A=D.map(([w,v])=>({w,v})).sort((a,b)=>b.v-a.v)
VC=A.map(a=>a.v)
WC=A.map(a=>a.w).sort((a,b)=>a-b)
V=0
BT(0,0,0)
console.log(V)

function BT(i,w,v){
  if (cut(i,w,v)) {
    //console.log("i:%d w:%d v:%d V:%d cut", i, w, v, V)
    return
  }
  if (i==N) return V=v>V?v:V
  BT(i+1, w+A[i].w, v+A[i].v)
  BT(i+1, w, v)
}

function cut(i,w,v) {
  for (let j=0; ; ++j) {
    //console.log("j:%d w:%d v:%d V:%d", j, w, v, V)
    if (w>W) return true
    if (v>=V) return false
    if (j>=N-i) return false;
    w+=WC[j]
    v+=VC[j]
  }
  return true
}

