N=+(require('fs').readFileSync(0)+'');
P=[,0,.5];
for(n=3;n<=N;++n)P[n]=P[n-1]+(n-1)/2;
console.log(P[N])