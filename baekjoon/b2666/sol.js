D=(require('fs').readFileSync(0)+'').trim().split(/\s+/).map(e=>+e);
L=D[0];
N=D[3];
A=D.slice(4);
M=Array(N).fill().map(e=>Array(L+1).fill().map(e=>[]));
BT=(n,x,y)=>{
 if(n==N)return 0;
 if(M[n][x][y]!=undefined)return M[n][x][y];
 let t=A[n],r;
 if(t<=x) r=BT(n+1,t,y)+x-t;
 else if(t>=y) r=BT(n+1,x,t)+t-y;
 else r=Math.min(BT(n+1,t,y)+t-x,BT(n+1,x,t)+y-t);
 return M[n][x][y]=r;
}
console.log(BT(0,D[1],D[2]));