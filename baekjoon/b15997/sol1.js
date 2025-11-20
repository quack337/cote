D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' '));
[a,b,c,d]=D[0];
I={[a]:0,[b]:1,[c]:2,[d]:3};
A=[[],[],[],[]];
G=[];
for(let i=1;i<7;++i){
 [a,b,w,d,l]=D[i];a=I[a];b=I[b];
 G.push([a,b])
 A[a][b]=[+w,+d,+l];
 A[b][a]=[+l,+d,+w];
}
S=[];
P=0;
X=[0,0,0,0];
B1=n=>{
 if(n==6){B2();return}
 for(let i=0;i<3;++i){S[n]=i;B1(n+1)}
}
B2=_=>{
  let p=1,J=[[0,0],[1,0],[2,0],[3,0]];
  for(let g=0;g<6;++g){
    let [a,b]=G[g],i,j;
    switch(S[g]){
      case 0:i=0;j=2;J[a][1]+=3;break;
      case 1:i=j=1;  J[a][1]++;J[b][1]++;break;
      case 2:i=2;j=0;J[b][1]+=3;break;
    }
    p*=A[a][b][i]*A[b][a][j];
  }
  P+=p;
  J.sort((a,b)=>a[1]-b[1]);
  let d=0,_j=-1;
  while(J.length){
    let[i,j]=J.pop();
    if(j!=_j){_j=j;if(++d>2)break;}
    X[i]+=p;
  }
}
B1(0);
console.log(P,X)
console.log(X.map(x=>x/P))
console.log(A)