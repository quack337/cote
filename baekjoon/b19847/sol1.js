D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];
A=D[1];
X=Array(A[0]).fill(1);
T=A[0];
for(let i=1;i<N;++i){
  let a=A[i];
  if(a>=T) continue;
  let c=T/a|0;
  for(let i=a;i<T;++i)X[i%a]+=X[i];
  T=a;
}
X=X.slice(0,T);
S=X.reduce((a,b)=>a+b);
Y=X.reduce((a,e,i)=>i*e+a,0)
console.log(Y/S)