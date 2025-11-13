D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,M]=D[0];
A=D[1];
BT=(n,m)=>{
  if(P[n][m]!=undefined)return P[n][m];
  if(m==1){let s=0;
    for(let i=n;i<N;++i)s+=A[i];
    return P[n][m]=s;
  }
  let s=0,x=Infinity;
  for(let i=n;i<=N-m;++i){
    s+=A[i];
    x=Math.min(x,Math.max(s,BT(i+1,m-1)));
  }
  return P[n][m]=x;
}
P=Array(N).fill().map(_=>[]);
x=BT(0,M);
X=[];
s=p=0;
for(let i=0;i<N;++i)
  if((s+=A[i])>x){
    X.push(i-p);
    s=A[i];p=i;
  }
X.push(N-p);
console.log(x+'\n'+X.join(' '))