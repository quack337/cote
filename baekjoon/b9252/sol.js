BT=(i,j)=>{let s,t
 if(i==XN||j==YN)return ''
 if(M[i][j]!=null)return M[i][j]
 return M[i][j]=X[i]==Y[j]?X[i]+BT(i+1,j+1):(s=BT(i,j+1),t=BT(i+1,j),s.length>t.length?s:t)
}
let[X,Y]=require('fs').readFileSync(0).toString().split('\n').map(s=>s.split(''))
XN=X.length
YN=Y.length
M=Array(XN).fill().map(_=>Array(YN).fill(null))
s=BT(0,0)
console.log(s.length + '\n' + s)