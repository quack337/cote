A=require('fs').readFileSync(0).toString().split(/[ \n]+/).map(e=>+e)
N=A.shift(), M=Array(N+1).fill().map(_=>[])
BT=(n,p)=>{
 if(n==N) return M[n][p]=0
 if(M[n][p]>-1) return M[n][p]
 return M[n][p]=Math.max(A[n]>p?BT(n+1,A[n])+1:0,BT(n+1,p))
}
BT(0,0)
p=0
X=[]
for(n=0;n<N;++n)
 if(M[n][p]==M[n+1][A[n]]+1) X.push(p=A[n])
console.log(M[0][0]+'\n'+X.join(' '))

