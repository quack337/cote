// 시간초과
A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
N=A.shift();
M=Array(N).fill(1);
X=1;
for(let i=N-2;i>=0;--i)
 for(let x=A[i]+1,j=i+1;j<N;++j)
  if(A[j]==x&&(M[i]+=M[j])>X){X=M[i];break;}
console.log(N-X)