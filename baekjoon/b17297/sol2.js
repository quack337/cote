M=(require('fs').readFileSync(0)+'')-1;
L=[,5,13];
for(i=3;L[i-1]<=M;++i)L[i]=L[i-1]+L[i-2]+1;
A='Messi Gimossi ';
for(;M>13;--i)if(M>L[i])M-=L[i]+1;
console.log(A[M]==' '?'Messi '+A:A[M])