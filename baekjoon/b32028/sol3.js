A=(require('fs').readFileSync(0)+'').trim().split('\n').map(s=>s.trim().split(' ').map(e=>+e));
N=A[0][0];
B=[];X=[];E=[,-1];
for(i=1;i<=N;++i){
  [v,h]=A[i]
  if(!B[h])B[h]=[];
  B[h].push([v,i])}
for(i=1;i<B.length;++i)if(B[i])B[i].sort((a,b)=>b[0]-a[0]);
fail=_=>{console.log(-1);process.exit()}
last=b=>b[b.length-1][0];
between=(v,mn,mx)=>v>=mn&&v<=mx;
if(!B[1]||B[1].length!=1)fail();
BT(1,B[1].pop(),-Infinity,Infinity);
for(i=1;i<B.length;++i)if(!B||B[i].length)fail();
console.log(X.join('\n').trim());

function BT(d,n, mn, mx){
  let b=B[d+1],l=E,r=E,t;
  if(b && b.length && between(last(b),mn,mx)){
    t=b.pop();
    if(t[0]<n[0]){
      l=t;
      if(b.length && b.length && between(last(b),mn,mx)){
        r=b.pop();
        if(r[0]<n[0])fail()}}
    else r=t}
  X[n[1]]=l[1]+' '+r[1];
  if(l[1]>0)BT(d+1,l,mn,n[0]);
  if(r[1]>0)BT(d+1,r,n[0],mx)}