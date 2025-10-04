IN=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
N=IN[0][0],T=IN[2][0]
A=IN[1]
W=IN[3]
X=[]
P=Array(N).fill().map(_=>[])
BT=(n, w)=>{
 if(!w)return 1
 if(n==N)return 0
 if(P[n][w]!=undefined)return P[n][w]
 return P[n][w]=BT(n+1,w)||BT(n+1,w+A[n])||BT(n+1,w-A[n])
}
for(t=0;t<T;++t)X.push(BT(0,W[t])?'Y':'N')
console.log(X.join(' '))