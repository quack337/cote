B=1000000007;N=5000;
M=Array(N).fill().map(_=>[]);
M[0]=Array(N+1).fill(1);
for(let n=1;n<N;++n){
  M[n][1]=(M[n-1][2]+M[n-1][1])%B;
  for(let i=2;i<=N-n;++i)
    M[n][i]=(M[n][i-1]+M[n-1][i+1])%B;
}
D=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
T=D[0];X='';
for(let t=1;t<=T;++t)X+=(D[t]%2?0:M[D[t]/2-1][1])+'\n';
console.log(X);