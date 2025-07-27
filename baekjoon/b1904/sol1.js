// stack overflow
N=+require('fs').readFileSync(0)
M=[]
BT=n=>{
 if(n==0)return 1
 if(M[n])return M[n]
 return M[n]=BT(n-1)+(n>1?BT(n-2):0)
}
console.log(BT(N))