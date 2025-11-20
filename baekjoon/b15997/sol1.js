D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' '));
[a,b,c,d]=D[0];
I={[a]:0,[b]:1,[c]:2,[d]:3};
G=[];
for(let i=1;i<7;++i){
 [a,b,w,d,l]=D[i];a=I[a];b=I[b];
 G.push([a,b,+w,+d,+l]);
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
    p*=G[g][i+2];
  }
  P+=p;
  let a=J.map(j=>j[1]), j1=Math.max(...a), j2=Math.max(...a.map(j=>j==j1?0:j));
  let c1=a.reduce((c,j)=>j==j1?c+1:c,0), c2=a.reduce((c,j)=>j==j2?c+1:c,0);
  J.forEach(([i,j])=>X[i] += j==j1 ? p/(c1>1?2/c1:1) : j==j2&&c1==1? p/c2 : 0);
}
B1(0);
console.log(X.join('\n'))