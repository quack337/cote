[X,L,R,N]=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
C=[,'132','211','232'];
J=(a,b)=>{a[0]+=b[0];a[1]+=b[1];a[2]+=b[2]}
D=Array(N+1).fill().map(_=>[]);
H=(n,x)=>{
 if(D[n][x])return D[n][x];
 let r=[0,0,0],c;
 if(!n)r[x-1]=1;else for(c of C[x])J(r,H(n-1,+c));
 return D[n][x]=r}
F=(n,x,l,r)=>{
 if(!l&&r==3**n-1)return H(n,x);
 let u=3**n/3,p=[0,0,0],c=C[x];
 if(n<2){if(!n)p[x-1]=1;else for(let i=l;i<=r;++i)p[c[i]-1]++}
 else{
  if(l<u)J(p,F(n-1,+c[0],l,r<u?r:u-1));
  if(r>=u&&l<u*2)J(p,F(n-1,+c[1],l<u?0:l-u,r<u*2?r-u:u-1));
  if(r>=u*2)J(p,F(n-1,+c[2],l<u*2?0:l%u,r%u))}
 return p}
console.log(F(N,X,L,R).join(' '))