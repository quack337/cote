[S,N,K,A,B,C,D]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
F=(s,r,c)=>{
 w=N**s,v=w/N,x=K*v,y=(w-x)/2;
 return r>=y&&c>=y&&r<w-y&&c<w-y?1:s<2?0:F(s-1,r%v,c%v)}
X=[];
for(r=A;r<=B;++r){X.push(t=[]);
for(c=C;c<=D;++c)t.push(F(S,r,c))}
console.log(X.map(x=>x.join('')).join('\n'))