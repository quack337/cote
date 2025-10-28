let A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
let N=A.shift();
let E=Array(N).fill().map(_=>[]);
for(let i=1; i<N; ++i)
  E[A[i]].push(i);
console.log(BT(0));

function BT(n){
  let e=E[n], en=e.length;
  if(!en) return 0;
  let r=Array(en);
  for(let i=0; i<en; ++i) r[i]=BT(e[i]);
  r.sort((a,b)=>b-a);
  let x=r[0];
  for (let i=1; i<en; ++i)
    x = Math.max(x, r[i]+i)
  return x+1;
}