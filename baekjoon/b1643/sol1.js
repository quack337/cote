A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
for(let i=0;i<A.length;++i){
  N=A[i];
  X=1;
  for(let n=1;n<N;++n)X+=N/(N-n);
  console.log(X);
}
