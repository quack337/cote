D=(require('fs').readFileSync(0)+'').split('\n');
N=+D.shift();
A=D.map(s=>s.split('').map(e=>+e));
M=Array(N).fill().map(_=>Array(10).fill().map(_=>[]));
BT=(n,p,v)=>{
  let m=M[n][p],x=0;if(m[v]!=undefined)return m[v];
  for(let i=0;i<N;++i){let b=1<<i,t;
    if(!(b&v)&&A[n][i]>=p){
      t=BT(i,A[n][i],v|b);if(t>x)x=t;}
  }
  return m[v]=x+1;
}
console.log(BT(0,0,1))