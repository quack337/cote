// BFS 구현
let IN=require('fs').readFileSync(0).toString().split('\n'),
[RN,CN,T]=IN[0].split(' ').map(e=>+e),
A=IN.slice(1).map(s=>s.split('')), G,N,B=[],DIST
for (let r=0; r<RN; ++r)
  for (let c=0; c<CN; ++c) {
    if (A[r][c]=='G') G=[r,c]
    else if (A[r][c]=='S') B.push([r,c])
  }
B=[G,...B]; N=B.length
DIST=Array(N).fill().map(_=>[])
console.log(BFS(0,1))
console.log(BFS(0,2))
console.log(BFS(0,3))
console.log(BFS(1,3))

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


