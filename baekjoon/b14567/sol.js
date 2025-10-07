D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,M]=D[0];
A=Array(N).fill().map(_=>[]);
for(let i=1;i<=M;++i) {
  let[a,b]=D[i];
  A[b-1].push(a-1);
}
M=Array(N);
for(let i=0;i<N;++i) BT(i);
console.log(M.join(' '));

function BT(n){
  if (M[n]) return M[n];
  return M[n] = A[n].reduce((g,e)=>{let t=BT(e); return t>g?t:g;},0)+1;
}