[p,q]=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
A=[2,3,5,7,11,13,17];
N=18;
nCr=Array(N+1).fill().map((_,i)=>Array(i+1).fill(1));
for(let n=2;n<=N;++n)
for(let r=1;r<n;++r)nCr[n][r]=nCr[n-1][r-1]+nCr[n-1][r];
FN=p=>A.map(r=>Math.pow(p,r)*Math.pow(1-p,N-r)*nCr[N][r]).reduce((a,b)=>a+b);
x=FN(p/100);y=FN(q/100);
console.log(x+y-x*y)