let IN=require('fs').readFileSync(0).toString().split('\n'),
[RN,CN,T]=IN[0].split(' ').map(e=>+e),
A=IN.slice(1).map(s=>s.split('')), G,B=[],BN,DIST,V=[],X=0
for (let r=0; r<RN; ++r)
  for (let c=0; c<CN; ++c) {
    if (A[r][c]=='G') G=[r,c]
    else if (A[r][c]=='S') B.push([r,c])
  }
B=[G,...B]; BN=B.length
DIST=Array(BN).fill().map(_=>[])
DFS(0,T,0)
console.log(X)

function DFS(a,t,x) {
  if (t>=0 && x>X) X=x
  if (t<=0) return
  for (let b=1; b<BN; ++b)
    if (!V[b]) { V[b]=1; DFS(b,t-BFS(a,b),x+1); V[b]=0 }
}

function BFS(i0, ig) {
  if (DIST[i0][ig]) return DIST[i0][ig]
  let [r0,c0] = B[i0], [rg,cg] = B[ig]
  let qf=0, qe=0, queue=new Map(), V=Array(RN).fill().map(_=>[])
  queue.set(qe++, [r0,c0,0])
  while (queue.size > 0) {
    let [r,c,dist] = queue.get(qf); queue.delete(qf++)
    if (V[r][c] || A[r][c]=='#') continue;
    V[r][c]=1
    if (r==rg && c==cg) return DIST[i0][ig] = DIST[ig][i0] = dist
    if (r>0) queue.set(qe++, [r-1,c,dist+1])
    if (c>0) queue.set(qe++, [r,c-1,dist+1])
    if (r<RN-1) queue.set(qe++, [r+1,c,dist+1])
    if (c<CN-1) queue.set(qe++, [r,c+1,dist+1])
  }
}