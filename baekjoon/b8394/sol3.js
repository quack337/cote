N=+(require('fs').readFileSync(0)+'');
M=Array(N);
M[N-1]=M[N]=1;
for(let i=N-2;i>=0;--i)
  M[i]=M[i+1]+M[i+2];
console.log(M[0]%10)