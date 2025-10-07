A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
N=A.shift();
M=Array(N).fill().map(_=>[]);
BT=(n,p)=>{
 if(n==N)return 0;
 if(M[n][p]!=undefined)return M[n][p];
 return M[n][p]=Math.max(A[n]<p?BT(n+1,A[n])+1:0,BT(n+1,p));
}
console.log(N-BT(0,Infinity));