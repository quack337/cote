IN=(require('fs').readFileSync(0)+'').split('\n')
T=+IN[0]
X=[]
BT=(r,c)=>{
  if (c==9) {c=0; if(++r==9) {X.push(A.map(e=>e.join('')).join('\n')); return 1}}
  if (A[r][c]) return BT(r,c+1)
  let U=[],U1=[],U2=[],U3=[] // 중복되는 값 오류처리
  for (let i=0; i<9; ++i) {
    let a=A[i][c], b=A[r][i]
    if ((a&&U1[a])||(b&&U2[b])) return 0
    U[a]=U[b]=U1[a]=U2[b]=1
  }
  let r0=((r/3)|0)*3, c0=((c/3)|0)*3
  for (let i=0; i<3; ++i)
    for (let j=0; j<3; ++j) {
      let a=A[r0+i][c0+j]
      if (a&&U3[a]) return 0
      U[a]=U3[a]=1
    }
  for (let i=1; i<=9; ++i)
    if (!U[i]) {A[r][c]=i; if(BT(r,c+1)) return 1; A[r][c]=0}
}
for (t=0; t<T; ++t) {
  A=IN.slice(1+t*9, 10+t*9).map(e=>e.split('').map(e=>+e))
  if (!BT(0,0)) X.push('Could not complete this grid.')
}
console.log(X.join('\n\n'))