A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,M,H]=A.shift();
DP=Array(N).fill().map(_=>[]);
F=(n,h)=>{
  if(!h) return 1;
  if(n==N) return 0;
  if(DP[n][h]!=undefined)return DP[n][h];
  let r=F(n+1,h);
  for(let i=0;i<A[n].length;++i)
    if(A[n][i]<=h) r=(r+F(n+1,h-A[n][i]))%10007;
  return DP[n][h]=r;
}
console.log(F(0,H));