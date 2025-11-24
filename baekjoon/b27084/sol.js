D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];
C=Array(N+1).fill(0);
for(let i=0;i<N;++i)C[A[i]]++;
F=0;H=0;J=1;
for(let i=0;i<N;++i){
  let c=C[i];
  if(c>1) {H+=c; J*=(c+1)}
  else if(c==1) ++F;

}
F=1<<F;
H=1<<H;
J=1<<J;
G=H-J;
K=F*G;
E=1<<N;
console.log(E,K)
console.log("F:%d G:%d H:%d J:%d K:%d", F,G,H,J,K)
