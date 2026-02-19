N = 0n;
for(let i=1; N <= 1e18; ++i)
  N = N * 2n + 1n;
F=(n, k)=>{
  let not = false;
  for(;;) {
    let m = (n - 1n) / 2n;
    if (k == 0n || k == m)
      return not ? 1 : 0; 
    if (k < m) 
      n = m; 
    else {
      not = !not; n = m; k = m-(k-m);
    }
  }
}

K=(require('fs').readFileSync(0)+'').split('\n').map(e=>BigInt(e));
X=[];
T=K[0];
for(t=1;t<=T;++t)
  X.push('Case #' + t + ': ' + F(N,K[t]-1n));
console.log(X.join('\n'))

// 정답