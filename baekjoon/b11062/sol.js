D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
T=D[0][0];
BT=(s,e,g)=>{
 if(s>e)return 0;
 if(M[s][e]!=undefined)return M[s][e];
 let a=BT(s+1,e,!g)+(g?A[s]:0),b=BT(s,e-1,!g)+(g?A[e]:0);
 return M[s][e]=g?(a>b?a:b):(a<b?a:b);
}
X='';
for(let t=0,i=0;t<T;++t){
 N=D[++i][0];A=D[++i];
 M=Array(N).fill().map(e=>Array(N));
 X+=BT(0,N-1,1)+'\n';
}
console.log(X);