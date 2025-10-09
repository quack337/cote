N=+(require('fs').readFileSync(0)+'');
P=Array(N+1);
P[1]=false;
P[2]=true;
P[3]=false;
P[4]=true;
for(let i=5; i<=N; ++i)
  P[i]=!(P[i-1]&&P[i-3]&&P[i-4]);
console.log(P[N]?'SK':'CY');