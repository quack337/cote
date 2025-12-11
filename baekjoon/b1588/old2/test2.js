N=3;
C=[,[1,3,2],[2,1,1],[2,3,2]];
F=(n,x,i)=>{
  if(n<2) return n?C[x][i]:x;
  let u=3**(n-1);
  return F(n-1,C[x][i/u|0],i%u)}
D=Array(N+1).fill().map(_=>[]);
D[0]=[,[1,0,0],[0,1,0],[0,0,1]];
D[1]=[,[1,1,1],[2,1,0],[0,2,1]];
J=(a,b,s)=>[a[0]+b[0]*s,a[1]+b[1]*s,a[2]+b[2]*s];
H=(n,x)=>{
  if(D[n][x])return D[n][x];
  let r=[0,0,0],c=C[x];
  for(let i=0;i<3;++i)r=J(r,H(n-1,c[i]),1);
  return D[n][x]=r}
for(let i=1;i<4;++i)
  console.log(H(3,i))