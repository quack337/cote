N=+(require('fs').readFileSync(0)+'');
A=B=C=1n;
for(i=4;i<=N;++i){D=C+A;A=B;B=C;C=D}
console.log(N<4?1:D+'')