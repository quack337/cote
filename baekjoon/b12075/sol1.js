N = 0n;
for(let i=1; N <= 1e18; ++i)
  N = N * 2n + 1n;
F=(n, k)=>{
  let m = (n - 1n) / 2n;
  if (k == 0n || k == m) { 
    return false; 
 }
 let r = k < m ? F(m, k) : !F(m, m-(k-m));
 return r;
}

K=(require('fs').readFileSync(0)+'').split('\n').map(e=>BigInt(e));
X=[];
T=K[0];
for(t=1;t<=T;++t)
  X.push('Case #1: ' + (F(N,K[t]-1n) ? 1 : 0));
console.log(X.join('\n'))
// stack overflow