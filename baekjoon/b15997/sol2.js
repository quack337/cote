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
 let p=1,J=[0,0,0,0];
 for(let g=0;g<6;++g){
  let [a,b]=G[g],s=S[g],[c,d]=[[3,0],[1,1],[0,3]][s];
  J[a]+=c;J[b]+=d;p*=G[g][s+2];
 }
 P+=p;
 let j1=Math.max(...J), j2=Math.max(...J.map(j=>j==j1?0:j));
 let c1=J.reduce((c,j)=>j==j1?c+1:c,0), c2=J.reduce((c,j)=>j==j2?c+1:c,0);
 J.forEach((j,i)=>X[i] += j==j1?p/(c1>1?c1/2:1) : j==j2&&c1==1?p/c2 :0);
}
B1(0);
console.log(X.join('\n'))