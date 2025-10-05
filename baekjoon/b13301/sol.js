N=+(require('fs').readFileSync(0)+'')
a=4n
b=6n
for(i=2;i<N; ++i){t=b;b=a+b;a=t}
console.log(N==1?4:N==2?6:b+'')