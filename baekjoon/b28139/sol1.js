A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=A.shift(0)[0];
X=0;Y=0;
S=[];V=[];
DIST=(i,j)=>{
  let a=A[i],b=A[j],x=a[0]-b[0],y=a[1]-b[1];
  return Math.sqrt(x*x+y*y);
}
BT=n=>{
  if(n==N){
    let x=0;
    console.log(S.join(' '));
    for(let i=1;i<N;++i)x+=DIST(S[i-1],S[i]);
    X+=x;++Y;
    return;
  }
  for(let i=0;i<N;++i)
    if(!V[i]){
      V[i]=1; S.push(i);
      BT(n+1);
      V[i]=0; S.pop(i);
    }
}
BT(0);
console.log(X,Y,X/Y);