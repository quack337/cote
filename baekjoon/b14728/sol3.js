let A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let [N,T]=A.shift();
let P=[0];
for (let i=N-1; i>=0; --i){
  let [u,v]=A[i];
  let Q=[...P];
  for (let x=0; x<P.length; ++x){
    let y=P[x];
    if (y>=0 && u+x<=T && (!Q[u+x] || Q[u+x]<v+y))
      Q[u+x]=v+y;
  }
  P=Q;
}
console.log([...P].reduce((g,v)=>v>g?v:g));
