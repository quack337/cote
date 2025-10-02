A=(require('fs').readFileSync(0)+'').split(/[\n ]/).map(e=>+e)
N=A.shift()
M=Array(N).fill().map(_=>[])
BT=(n,s)=>{
 if(n==N-1)return s==A[n]?1n:0n
 if(s<0n||s>20n)return 0n
 if(M[n][s]!=undefined)return M[n][s]
 return M[n][s]=BT(n+1,s+A[n])+BT(n+1,s-A[n])
}
console.log(BT(1,A[0])+'')