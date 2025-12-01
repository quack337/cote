// 문제를 오해하고, T초 이후에 충돌하는 횟수를 계산함
D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];
A=D[1].split(' ').map(e=>+e);
T=+D[2];
B=[];
CK=(a,b)=>a>=0 && b<N && C[a][0]+1==C[b][0] && C[a][1]==-1 && C[b][1]==1 ? 1 : 0;
B2=_=>{
  C=A.map((e,i)=>[e+B[i]*T,B[i]]).sort((a,b)=>a[0]-b[0]);
  let a,b,x=0;
  for(a=0;a<N;++a)if(C[a][1]>0)break;
  for(b=N-1;b>=0;--b)if(C[b][1]<0)break;
  if(a<b) console.log('A', a,b, C, b-a, CK(a-1,a), CK(b,b+1));
  else if(a==b+1 && CK(b,a)) console.log('B', a,b,C, CK(b,a));
}
B1=n=>{
  if(n==N) return B2();
  B[n]=-1;B1(n+1);
  B[n]=1;B1(n+1);
}
X=0;
B1(0);