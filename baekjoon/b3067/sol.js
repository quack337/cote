D=(require('fs').readFileSync(0)+'').split('\n');
T=+D[0];X='';
for(let t=0,d=1;t<T;++t){
  N=+D[d++]; A=D[d++].split(' ').map(e=>+e); P=+D[d++];
  M=Array(P+1).fill(0);M[0]=1;
  for(let i=0;i<N;++i)for(let j=A[i],a=j;j<=P;++j)M[j]+=M[j-a]
  X+=M[P]+'\n';
}
console.log(X);