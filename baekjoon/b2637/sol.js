let D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let N=D[0][0], M=D[1][0];
M+=2;
let A=Array(N).fill().map(_=>[]);
for (let i=2; i<M; ++i) {
  let [x,y,z]=D[i];
  --x;--y;
  A[x].push([y,z]);
}
P=Array(N);
let X='', p=BT(N-1);
for (let i=0; i<N; ++i)
  if (p[i]>0) X+=(i+1)+' '+p[i]+'\n';
console.log(X);

function BT(x){
  if (P[x]) return P[x];
  let p=Array(N).fill(0), a=A[x];
  if (a.length==0) p[x]=1;
  else
  for (let i=0; i<a.length; ++i){
    let [y,z]=a[i];
    let q=BT(y);
    for (let j=0; j<N; ++j) p[j]+=q[j]*z;
  }
  return P[x]=p;
}
