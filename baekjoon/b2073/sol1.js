// 메모리 초과 - DP
A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[D,N]=A.shift();
A=A.filter(a=>a[0]<=D);
DP=Array(N).fill().map(_=>({}));
F=(n,d)=>{
  if(n==N)return 0;
  if(DP[n][d]!=undefined)return DP[n][d];
  let [l,c]=A[n];
  let a = F(n+1,d);
  let b = d<l ? 0 : d==l ? c : Math.min(c,F(n+1,d-l));
  return DP[n][d] = Math.max(a,b);
}
console.log(F(0,D))