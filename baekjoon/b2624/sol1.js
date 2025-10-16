D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
T=D[0][0];
N=D[1][0];
A=D.slice(2);
M=Array(N).fill().map(e=>[]);
console.log(BT(0,T));

function BT(n,t){
  if(t==0) return 1;
  if(M[n][t]!=undefined)return M[n][t];
  let [p,q]=A[n], r=0
  if(n==N-1) return M[n][t] = t%p==0 && t/p<=q ? 1 : 0;
  for(let i=0;i<=q;++i){
    let tt=t-p*i;
    if(tt<0) break;
    r += BT(n+1,tt);
  }
  return M[n][t] = r;
}