// 시간초과. 다른 방법을 찾자
A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
T=A.shift();
BT=(n,x)=>{
 if(n==N)return x?0:1;
 if(M[n][x]!=undefined)return M[n][x];
 return M[n][x]=(BT(n+1,x+1)+(x?BT(n+1,x-1):0))%1000000007;
}
X='';
for(let i=0;i<T;++i){
 N=A[i];
 if(N%2){X+='0\n';continue;}
 M=Array(N).fill().map(e=>[]);
 X+=BT(0,0)+'\n';
}
console.log(X);