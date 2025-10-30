A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map((e,i)=>i?Math.round(e*100):+e));
X='';
for(;;){
 [N,M]=A.shift();if(!N)break;
 D=Array(M+1).fill(0);
 for(let i=0;i<N;++i){
  let[c,p]=A[i];
  for(let m=p;m<=M;++m){
   let t=D[m-p]+c;
   if(t>D[m])D[m]=t;
  }}
 X+=Math.max(...D)+'\n';A=A.slice(N);
}
console.log(X);