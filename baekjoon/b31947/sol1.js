[N,M,S,E]=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
A=Array(N).fill().map(_=>[]);X=0;Y=0;--S;--E;
F1=m=>{
  if(m==M)return F2();
  for(let n=0;n<N-1;++n)
    {A[n][m]=1;F1(m+1);A[n][m]=0}
}
F2=_=>{
  let n=S;
  for(let m=0;m<M;++m)
    n+=A[n][m]?1:n&&A[n-1][m]?-1:0;
  ++Y;if(n==E)++X;
}
F1(0);
console.log(X/Y)