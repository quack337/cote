N=require('fs').readFileSync(0)
if(N==1){console.log(1);return}
a=b=1n
for(i=2;i<=N;++i,a=b,b=c)c=b+a
console.log(c+'')