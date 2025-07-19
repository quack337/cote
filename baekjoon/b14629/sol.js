IN=require('fs').readFileSync(0).toString().trim()
N=IN.length
A=+IN
MN=1023456789
MX=9876543210
if (A>=MX) {console.log(MX); return}
V=[]
DF=Infinity
X=0
CHK=x=>{
  let df=Math.abs(A-x)
  if (df<DF) {DF=df; X=x}
  else if (df==DF&&x<X) X=x
}
BT=(n,x)=>{
  if(n==N) return CHK(x)
  for (let i=0; i<=9; ++i)
    if (!V[i]&&i+n) {V[i]=1; BT(n+1,x*10+i); V[i]=0}
}
BT(0,0)
CHK(+(''+MN).slice(0,N+1))
CHK(+(''+MX).slice(0,N-1))
console.log(X)
