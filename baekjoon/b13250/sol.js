N=+(require('fs').readFileSync(0)+'');
F=Array(N+1).fill(1);
for(let i=2;i<=N;++i)
  for(let j=1;j<=5&&i-j>=1;++j)
    F[i]+=F[i-j]/6;
console.log(F)