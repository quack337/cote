BT=(i,j)=>{
  if(i==XN||j==YN) return 0
  if(M[i][j]>-1) return M[i][j]
  if(X[i]==Y[j]) return M[i][j]=BT(i+1,j+1)+1
  return M[i][j]=Math.max(BT(i,j+1),BT(i+1,j))
}
let[X,Y]=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(''))
XS=new Set(X)
YS=new Set(Y)
clean=(A,S)=>A.filter(c=>S.has(c))
X=clean(X,YS)
Y=clean(Y,XS)
XN=X.length
YN=Y.length
M=Array(XN).fill().map(_=>Array(YN).fill(-1))
console.log(BT(0,0))