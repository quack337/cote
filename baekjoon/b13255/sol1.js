D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];K=+D[1];
A=D[2].split(' ').map(e=>+e);
F=Array(K);B=Array(K);
F[0]=N;B[0]=0;
for(let i=0;i<K;++i){
  let fp=A[i]/N * F[i]/N;
  let bp=A[i]/N * B[i]/N;
  B[i+1]=B[i]+F[i]*fp-B[i]*bp;
  F[i+1]=F[i]+B[i]*bp-F[i]*fp;
}
console.log(F[K])