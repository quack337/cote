D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];K=+D[1];
A=D[2].split(' ').map(e=>+e);
F=N;B=0;
for(let i=0;i<K;++i){
  let fp=A[i]/N*F/N, bp=A[i]/N*B/N;
  [B,F]=[B+F*fp-B*bp,F+B*bp-F*fp];
}
console.log(F)