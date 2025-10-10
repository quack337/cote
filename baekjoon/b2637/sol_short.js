D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];
M=D[1][0];
M+=2;
A=Array(N).fill().map(_=>[]);
for(let i=2;i<M;++i){
  let [x,y,z]=D[i];--x;--y;
  A[x].push([y,z]);
}
BT=x=>{
  if(P[x])return P[x];
  let p=Array(N).fill(0),a=A[x];
  if(a.length==0)p[x]=1;else
  for(let i=0;i<a.length;++i){
    let[y,z]=a[i];
    let q=BT(y);
    for(let j=0;j<N;++j)p[j]+=q[j]*z;
  }
  return P[x]=p;
}
P=Array(N);
p=BT(N-1);
console.log(p.reduce((g,c,i)=>c?g+(i+1)+' '+c+'\n':g,''));