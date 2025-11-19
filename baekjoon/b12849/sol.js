T=+(require('fs').readFileSync(0)+'').trim();
A=[[1,7],[0,2,7],[1,3,6,7],[2,4,6],[3,5],[4,6],[2,3,5,7],[0,1,2,6]];
M=Array(A.length).fill().map(_=>[]);
BT=(n,t)=>{
 if(!t)return !n?1:0;
 if(M[n][t]!=undefined)return M[n][t];
 let a=A[n],x=0;
 for(let i=0;i<a.length;++i)x=(x+BT(a[i],t-1))%(1e9+7);
 return M[n][t]=x;
}
console.log(BT(0,T))