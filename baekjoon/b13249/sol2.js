D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];
A=D[1].split(' ').map(e=>+e);
T=+D[2];
CK=(B,a,b)=>a>=0 && b<N && B[a][0]+1==B[b][0] && B[a][1]==-1 && B[b][1]==1 ? 1 : 0;
F3=(B,ck)=>{
  B.sort((a,b)=>a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
  let a,b,x=0;
  for(a=0;a<N;++a)if(B[a][1]>0)break;
  for(b=N-1;b>=0;--b)if(B[b][1]<0)break;
  if(!ck)return a<b ? b-a : 0;
  if(a<b)return b-a+CK(B,a-1,a)+CK(B,b,b+1);
  else if(a==b+1) return CK(B,b,a);
}
F2=_=>{
  let x0 = F3(B,0);
  let C=B.map(b=>[b[0]+b[1]*T,b[1]]);
  let x1 = F3(C,0);
  if(x0-x1<0) {
    console.log('error', x0-x1);
    process.exit(0);
  }
  X += x0-x1;
  if(x0-x1) {
    console.log(B.map(e=>e.join()).join(' '),x0-x1, x0, x1);
    //console.log(C.map(e=>e.join()).join(' '));
  }
}
F1=n=>{
  if(n==N) return F2();
  B[n][0]=A[n];
  B[n][1]=-1;F1(n+1);
  B[n][1]=+1;F1(n+1);
}
X=0;
B=A.map(e=>[]);
F1(0)
console.log(X,(1<<N))