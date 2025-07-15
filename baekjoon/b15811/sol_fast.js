let ndx = c=>(c).charCodeAt(0)-'A'.charCodeAt(0),
[X,Y,Z]=require('fs').readFileSync(0).toString().trim().split(' ').map(s=>s.split('').map(c=>ndx(c))),
A=[], S=Array(26).fill(-1), V=[];
[...X, ...Y, ...Z].forEach(i=> A[i]=1)
console.log(DFS(0) ? 'YES' : 'NO')

function DFS(n) {
  if (n==26) {
    let val = p=>p.map(i=>S[i]).reduce((r,e)=>r*10+e, 0)
    let x=val(X), y=val(Y), z=val(Z)
    return x+y==z
  }
  if (!valid()) return 0
  if (!A[n]) return DFS(n+1)
  for (let i=0; i<=9; ++i)
    if (!V[i]) {
      S[n]=i; V[i]=1
      if (DFS(n+1)) return 1
      S[n]=-1; V[i]=0
    }
}

function valid() {
  let xn=X.length, yn=Y.length, zn=Z.length
  let nn = Math.max(xn, yn, zn)
  if (zn>xn && zn>yn && S[Z[0]]>1) return false
  for (let i=0; i<nn; ++i) {
    if ((xn>i && S[X[xn-i-1]]==-1) || (yn>i && S[Y[yn-i-1]]==-1) ||
        (zn>i && S[Z[zn-i-1]]==-1)) continue
    let x = xn>i ? S[X[xn-i-1]] : 0,
      y = yn>i ? S[Y[yn-i-1]] : 0, z = zn>i ? S[Z[zn-i-1]] : 0;
    let xy = x+y;
    if (i==0) { if (xy%10 != z%10) return 0 }
    else { if (xy%10 != z%10 && (xy+1)%10 != z%10) return 0 }
  }
  return 1
}
