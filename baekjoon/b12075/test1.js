N = 0n;
for(let i=1; N <= 1e5; ++i)
  N = N * 2n + 1n;

F=(n, k)=>{
  //console.log(n, k);
  let m = (n - 1n) / 2n;
  if (k == 0n || k == m) { 
    // console.log(n, false); 
    return false; 
 }
 let r = k < m ? F(m, k) : !F(m, m-(k-m));
 // console.log(n, r);
 return r;
}

console.log(F(N, 0n));
//console.log('------');
console.log(F(N, 1n));
//console.log('------');
console.log(F(N, 2n));
console.log(F(N, 3n));
console.log(F(N, 4n));
console.log(F(N, 5n));
console.log(F(N, 6n));
