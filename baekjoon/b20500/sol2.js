N=+(require('fs').readFileSync(0)+'');
x=0;
for(let i=2;i<=N;++i)x=(x+x+(i%2?-1:1))%(1e9+7);
console.log(x)