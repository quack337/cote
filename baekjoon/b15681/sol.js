let IN=(require('fs').readFileSync(0)+'').split('\n');
let [N,R,Q]=IN[0].split(' ').map(e=>+e);
let E=Array(N+1).fill().map(_=>[]);
for (let i=0; i<N-1; ++i) {
  let [a,b]=IN[i+1].split(' ');
  E[a].push(b); E[b].push(a);
}
let M=Array(N),X=[];
BT(R,-1);
for (let i=0; i<Q; ++i)
  X.push(M[+IN[N+i]])
console.log(X.join('\n'));

function BT(n,p) {
  if (M[n]!=undefined) return M[n];
  let s=1,A=E[n];
  for(let i=0; i<A.length; ++i) {
    let c=A[i]; if(c==p) continue;
    s+=BT(c,n);
  }
  return M[n]=s;
}