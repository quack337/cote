N=+(require('fs').readFileSync(0)+'').trim()
A=[5,3]
M=[]
DP=n=>{
 if (n==3||n==5) return 1
 if (M[n]) return M[n]
 let x=Infinity
 if (n>5) x=Math.min(x,DP(n-5)+1)
 if (n>3) x=Math.min(x,DP(n-3)+1)
 return M[n]=x
}
x=DP(N)
console.log(x<Infinity?x:-1)