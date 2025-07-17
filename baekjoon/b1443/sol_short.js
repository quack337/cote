[D,N]=(''+require('fs').readFileSync(0)).split(' ').map(e=>+e)
M=Math.pow(10,D)
X=-1
function BT(b,x,n) {
 if(n==N) {if(x>X) X=x}
 else
 for(let i=b;i<=9;++i)
  if(x*i<M) BT(i,x*i,n+1)
}
BT(2,1,0)
console.log(X)