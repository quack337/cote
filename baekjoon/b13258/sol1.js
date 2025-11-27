D=(require('fs').readFileSync(0)+'').split('\n')
N=+D[0]
A=D[1].split(' ').map(e=>+e);
J=+D[2];C=+D[3];
S=A.reduce((a,e)=>a+e);
P=Array(C+1);Q=Array(C+1);
P[0]=0;Q[0]=A[0];
for(let i=1;i<=C;++i){
  P[i]=Q[i-1]/(S+J*(i-1));
  Q[i]=Q[i-1]+J*P[i];
}
console.log(Q[C])