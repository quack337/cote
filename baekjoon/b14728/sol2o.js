// 통과 .. 느리다..
let A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let [N,T]=A.shift();
let P={0:0};
console.log(P);
for (let i=N-1; i>=0; --i){
  let [u,v]=A[i];
  let Q={...P};
  Object.entries(P).forEach(([x,y])=> {
    x|=0;
    if (u+x<=T && (!Q[u+x] || Q[u+x]<v+y))
      Q[u+x]=v+y;
  });
  P=Q;
  console.log(P);
}
console.log([...Object.values(P)].reduce((g,v)=>v>g?v:g));
