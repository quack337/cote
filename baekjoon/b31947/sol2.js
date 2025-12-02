[N,M,S,E]=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
A=Array(N+1).fill(0);B=[];A[S]=1;P=1/(N-1);
while(M--){
 B[1]=A[1]*(1-P)+A[2]*P;B[N]=A[N]*(1-P)+A[N-1]*P;
 for(let n=2;n<N;++n)B[n]=A[n]*(1-P-P)+A[n-1]*P+A[n+1]*P;
 T=A;A=B;B=T;
}
console.log(A[E])