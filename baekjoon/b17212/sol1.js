M=+(require('fs').readFileSync(0)+'');
A=[7,5,2,1];
P=Array(M+1).fill().map(_=>[]);
BT=(m,n)=>{
 if(n==3) return P[m][n]=m;
 if(P[m][n]!=undefined)return P[m][n];
 let x=Infinity,a=A[n];
 for(let j=m/a|0;j>=0;--j)x=Math.min(x,BT(m-a*j,n+1)+j);
 return P[m][n]=x;
}
console.log(BT(M,0))