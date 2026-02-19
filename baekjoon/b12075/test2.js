N = 0n;
for(let i=1; N <= 1e5; ++i)
  N = N * 2n + 1n;

F=(n, k)=>{
  let m = (n - 1n) / 2n;
  if (k == 0n || k == m) { 
    return false; 
 }
 let r = k < m ? F(m, k) : !F(m, m-(k-m));
 return r;
}

X=[];
for(k=0n; k<15n; ++k)
 X.push(F(N, k) ? 1 : 0);
console.log(X.join(''))