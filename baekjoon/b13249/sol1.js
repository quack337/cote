D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];
A=D[1].split(' ').map(e=>+e);
T=+D[2];
B=[];
F1=n=>{
  if(n==N)return F2();
  B[n]=-1;F1(n+1);
  B[n]=+1;F1(n+1);
}
F2=_=>{
  for(let i=0;i<N;++i)
    if(B[i]==1){
      let s=A[i],e=A[i]+T;
      for(let j=0;j<N;++j)
        if(B[j]==-1 && s<A[j] && e>=A[j]-T) ++X;
    }
}
X=0;
F1(0);
console.log(X/(1<<N))