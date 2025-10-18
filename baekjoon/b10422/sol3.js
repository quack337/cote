// logic.txt 에서 새 방법을 정리함. 시간 초과
A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
T=A.shift();
BT=(n,p)=>{
 if(n==N-1)return M[n][p]=1;
 if(M[n][p]!=undefined)return M[n][p];
 let r=BT(n+1,p);
 if(p<N-1)r+=BT(n+1,p+1);
 for(let q=0;q<p;++q)
  r = (r+BT(n+1,q))%1000000007;
 return M[n][p]=r;
}
X='';
for(let i=0;i<T;++i){
 N=A[i];
 if(N%2){X+='0\n';continue;}
 M=Array(N/=2).fill().map(e=>[]);
 X+=BT(0,0)+'\n';
}
console.log(X)