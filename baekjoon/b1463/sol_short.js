X=+require('fs').readFileSync(0)
M=[,0]
for(x=2;x<=X;++x)M[x]=Math.min(x%3?X:M[x/3],x%2?X:M[x/2],M[x-1])+1
console.log(M[X])