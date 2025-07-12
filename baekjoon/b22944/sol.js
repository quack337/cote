let IN=require('fs').readFileSync(0).toString().split('\n'),
[N,H,DEF]=IN[0].split(' ').map(e=>+e), A=IN.slice(1).map(s=>s.split('')),
abs=Math.abs, distance=([r1,c1],[r2,c2])=>abs(r1-r2)+abs(c1-c2),
ST,END,UB=[],V=[],X=Infinity
for (let r=0; r<N; ++r)
  for (let c=0; c<N; ++c) {
    let ch=A[r][c], p=[r,c]
    if (ch=='S') ST=p; else if (ch=='E') END=p; else if (ch=='U') UB.push(p)
  }
UB=[ST, ...UB, END]; END=UB.length-1
DFS(0,H,0,0)
console.log(X<Infinity ? X : -1)

function DFS(a,h,def,x) {
  if (x>X) return
  if (a==END) { if (x<X) X=x }
  for (let b=1; b < UB.length; ++b)
    if (!V[b]) {
      let dist=distance(UB[a],UB[b]);
      if (dist > def+h) continue
      V[b]=1
      DFS(b, (dist>def ? h+def-dist : h), DEF, x+dist)
      V[b]=0
    }
}