N=+(require('fs').readFileSync(0)+'')
A=(1<<10)-1
M=1000000000
P=Array(N).fill().map(_=>Array(10).fill().map(_=>[]))
BT=(n,p,b)=>{
if(n==N)return b==A?1:0
if(P[n][p][b]!=undefined)return P[n][p][b]
let r=0
if(p>0)r=(r+BT(n+1,p-1,b|(1<<p-1)))%M
if(p<9)r=(r+BT(n+1,p+1,b|(1<<p+1)))%M
return P[n][p][b]=r}
r=0
for(i=1;i<=9;++i)r=(r+BT(1,i,1<<i))%M
console.log(r)