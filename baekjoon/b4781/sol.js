A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map((e,i)=>+e));
X='';
for(;;){
 [N,M]=A.shift();
 if(!N)break;
 M=Math.round(M*100);
 for(let i=0;i<N;++i)A[i][1]=Math.round(A[i][1]*100);
 D=Array(M+1).fill(0);
 for(let i=0;i<N;++i){
  let[c,p]=A[i];
  for(let m=p;m<=M;++m)
    D[m]=Math.max(D[m], D[m-p]+c);
 }
 X+=Math.max(...D)+'\n';
 A=A.slice(N);
}
console.log(X);