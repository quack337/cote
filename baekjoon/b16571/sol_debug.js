let A=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(' ').map(e=>+e)),
B=[], n1=0, n2=0
for (let r=0; r<3; ++r)
  for (let c=0; c<3; ++c)
    if (A[r][c]==1) ++n1
    else if (A[r][c]==2) ++n2
    else B.push([r,c])

let s = n1>n2 ? -1 : 1, r = s==-1 ? DFS2(0) : DFS1(0)
console.log(s==r ? 'W' : s+r==0 ? 'L' : 'D')

function DFS1(depth) {
  print(depth, "DFS1")
  let mx = -9
  for (let [r,c] of B)
    if (!A[r][c]) {
      print(depth, "1:", r, c)
      A[r][c]=1
      if (win(r,c)) { A[r][c]=0; print(depth, "w1:1"); return 1 }
      mx = Math.max(mx, DFS2(depth+1))
      A[r][c]=0
    }
  print(depth, "return", mx==-9 ? 0 : mx);
  return mx==-9 ? 0 : mx;
}

function DFS2(depth) {
  print(depth, "DFS2")
  let mn = 9
  for (let [r,c] of B)
    if (!A[r][c]) {
      print(depth, "2:", r, c)
      A[r][c]=2
      if (win(r,c)) { A[r][c]=0; print(depth, "w2:-1"); return -1 }
      mn = Math.min(mn, DFS1(depth+1))
      A[r][c]=0
    }
  print(depth, "return", mn==9 ? 0 : mn);
  return mn==9 ? 0 : mn;
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

function print(d, ...p) {
  console.error(Array(d*2).fill(' ').join(''), ...p)
}