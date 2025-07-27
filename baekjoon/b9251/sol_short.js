BT=(i,j)=>{
 if(i==XN||j==YN)return 0
 if(M[i][j]>-1)return M[i][j]
 return M[i][j]=X[i]==Y[j]?BT(i+1,j+1)+1:Math.max(BT(i,j+1),BT(i+1,j))
}
let[X,Y]=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(''))
XN=X.length
YN=Y.length
M=Array(XN).fill().map(_=>Array(YN).fill(-1))
console.log(BT(0,0))