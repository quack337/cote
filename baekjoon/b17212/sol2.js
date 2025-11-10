M=+(require('fs').readFileSync(0)+'');
A=[2,5,7];
P=Array(M+1);
for (let i=0; i<=M; ++i)P[i]=i;
for (let i=0; i<3; ++i)
  for(let a=A[i],j=a; j<=M; ++j)
    P[j] = Math.min(P[j], P[j-a]+1);  
console.log(P[M])