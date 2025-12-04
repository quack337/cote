[S,N,K,R1,R2,C1,C2]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
F=(s,r,c)=>{
 let w=N**s,v=w/N,x=K*v,y=(w-x)/2;
 if(r>=y&&c>=y&&r<w-y&&c<w-y)return 1;
 return s<2?0:F(s-1,r%v,c%v)}
X=[];
for(let r=R1;r<=R2;++r){X.push(x=[]);
for(let c=C1;c<=C2;++c)x.push(F(S,r,c))}
console.log(X.map(x=>x.join('')).join('\n'))
