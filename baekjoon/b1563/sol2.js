N=+(require('fs').readFileSync(0)+'');
M=Array(N).fill().map(_=>[[,,],[,,],[,,]]);
BT=(n,a,l)=>{
 if(n==N)return 1;let m=M[n][a];if(m[l]!=undefined)return m[l];
 return m[l]=(BT(n+1,0,l)+(a>=2?0:BT(n+1,a+1,l))+(l?0:BT(n+1,0,1)))%1e6;}
console.log(BT(0,0,0))