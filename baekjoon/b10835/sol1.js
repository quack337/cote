// 통과, 그런데 느리다
D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];B=D[2];
M=Array(N).fill().map(e=>[]);
BT=(a,b)=>{
 if(a==N||b==N)return 0;
 if(M[a][b]!=undefined)return M[a][b];
 return M[a][b]=Math.max(B[b]<A[a]?BT(a,b+1)+B[b]:0,BT(a+1,b),BT(a+1,b+1));
}
console.log(BT(0,0))