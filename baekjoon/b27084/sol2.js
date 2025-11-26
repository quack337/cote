D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];
C=Array(N+1).fill(0);
for(let i=0;i<N;++i)C[A[i]]++;
F=0;H=0;J=1;
for(let i=0;i<=N;++i){
  let c=C[i];
  if(c>1) {H+=c; J*=c+1}
  else if(c==1) ++F;
}
H=1<<H;J<<1;G=H-J;
console.log('C', C);
console.log("H:%d J:%d G:%d", H, J, G);
F=1<<F;K=F*G;
console.log("F:%d K:%d", F, K);
E=(1<<N)-1;
console.log("E:%d", E);
console.log(E-K)
