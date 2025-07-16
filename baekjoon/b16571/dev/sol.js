let A=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e)),
B=[], n1=0, n2=0
for (let r=0; r<3; ++r)
  for (let c=0; c<3; ++c)
    if (A[r][c]==1) ++n1
    else if (A[r][c]==2) ++n2
    else B.push([r,c])

if (B.length==0) { console.log(0); return }
let r = n1>n2 ? DFS2(0) : DFS1(0)
console.log(r)

function DFS1() {
  let mx = -9
  for (let [r,c] of B)
    if (!A[r][c]) {
      A[r][c]=1
      if (win(r,c)) { A[r][c]=0; return 1 }
      mx = Math.max(mx, DFS2())
      A[r][c]=0
    }
  return mx
}

function DFS2() {
  let mn = 9
  for (let [r,c] of B)
    if (!A[r][c]) {
      A[r][c]=2
      if (win(r,c)) { A[r][c]=0; return -1 }
      mn = Math.min(mn, DFS1())
      A[r][c]=0
    }
  return mn
}

function win(r,c) {
  let x=A[r][c], n1=0, n2=0
  for (let i=-2; i <=2; ++i) {
    if (r+i>=0 && r+i<=2 && A[r+i][c]==x) ++n1
    if (c+i>=0 && c+i<=2 && A[r][c+i]==x) ++n2
  }
  if (n1==3 || n2==3) return 1
  if (r==c && A[0][0]==x && A[1][1]==x && A[2][2]==x) return 1
  if (r+c==2 && A[0][2]==x && A[1][1]==x && A[2][0]==x) return 1
  return 0
}
