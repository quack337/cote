A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
M=[]
N=A.shift(0)[0]
BT=n=>{
 if(M[n])return M[n]
 let B=A[n],x=0
 for(let i=1;B[i]!=-1;++i)x=Math.max(x,BT(B[i]-1))
 return M[n]=B[0]+x
}
X=[]
for(i=0;i<N;++i)X.push(BT(i))
console.log(X.join('\n'))
