A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e)
N=A[0]
M=Array(N+1)
BT=n=>{
 if(n==N)return 0
 if(M[n])return M[n]
 let m=Infinity
 for(let i=1;i<=A[n];++i)
  m=Math.min(m,BT(n+i))
 return M[n]=m+1;
}
x=BT(1)
console.log(x<Infinity?x:-1)