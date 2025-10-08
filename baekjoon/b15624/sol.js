N=+(require('fs').readFileSync(0)+'');
A=0;B=1;
for(i=2;i<=N;++i){t=B;B=(B+A)%1000000007;A=t}
console.log(B)