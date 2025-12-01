[N,M,S,E]=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
P=1/(N-1);A=Array(N+2).fill(0);B=Array(N+2).fill(0);A[S]=1;
for(let m=0;m<M;++m){
  for(let n=1;n<=N;++n)B[n]=A[n]*(1-P-P)+A[n-1]*P+A[n+1]*P;
  [A,B]=[B,A];
}
console.log(A[E].toFixed(10))