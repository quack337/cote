A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split('').map(e=>+e))
D=[[-1,0],[0,1],[1,0],[0,-1]]
X=0
V=[]
BT=(r,c)=>{
 if (c==7) {c=0; if(++r==8) {++X; return}}
 let a=A[r][c], b
 if (a==9) return BT(r,c+1)
 for (let i=0; i<4; ++i) {
   let r1=r+D[i][0], c1=c+D[i][1]
   if (r1<0||c1<0||r1>7||c1>6) continue
   if ((b=A[r1][c1])==9) continue
   let k=a<b?a*10+b:b*10+a
   if (!V[k]) {
     V[k]=1; A[r][c]=A[r1][c1]=9
     BT(r,c+1)
     V[k]=0; A[r][c]=a; A[r1][c1]=b
   }
 }
}
BT(0,0)
console.log(X)