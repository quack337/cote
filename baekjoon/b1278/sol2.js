N=+(require('fs').readFileSync(0)+'');
X=[1,2,1,2];
for(i=3;i<=N;++i){X[X.length-1]=i;X.push(...X)}
console.log((X.length-1)+'\n'+X.join('\n'))