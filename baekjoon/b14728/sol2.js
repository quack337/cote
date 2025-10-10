// 통과 .. 그런데 여전히 느리다..
let A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let [N,T]=A.shift();
let P=new Map([[0,0]]);
for (let i=N-1; i>=0; --i){
  let [u,v]=A[i];
  let Q=new Map(P);
  P.forEach((y,x)=> {
    if (u+x<=T && (!Q.get(u+x) || Q.get(u+x)<v+y))
      Q.set(u+x,v+y);
  })
  P=Q;
}
console.log([...P.values()].reduce((g,v)=>v>g?v:g));
