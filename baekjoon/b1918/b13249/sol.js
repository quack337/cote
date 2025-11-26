D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];
A=D[1].split(' ').map(e=>+e);
T=+D[2];
B=[];
B1=n=>{
  if(n==N) return B2();
  B[n]=-1;B1(n+1);
  B[n]=1;B1(n+1);
}
B2=_=>{
  let C=A.map((e,i)=>e+B[i]*T);
  let a,b;
  for(a=0;a<N;++a)if(B[i]>0)break;
  for(b=N-1;b>=0;--b)if(B[i]<0)break;
}
