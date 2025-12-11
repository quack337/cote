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
E=l=>{for(let i=1;i<=20;++i)if(l<=3**i)return i}
P=(n,x,l)=>{//l<=i 위치 항목들 수
  let r,p,q;
  if(n<2){r=[0,0,0];for(let i=l,c=C[x];i<3;++i)r[c[i]-1]++;return r}
  r=H(n,x);
  if(!l)return r;
  let nn=E(l), xx=F(n-nn,x,0), u=3**(nn-1);
  if(3**nn==l){
    p=H(nn,xx);
    // console.log(nn,xx,p);
    return J(r,p,-1);
  }
  if(nn==1){
    p=H(nn,xx), q=P(nn,xx,l);
    // console.log(nn, u, xx, p, q);
    return J(J(r,p,-1),q,1);
  }
  let ii=l/u|0,c=C[xx]
  p=H(nn,xx);
  for(let i=0;i<3;++i){
    let xxx=c[i];
    if(i==ii)p=J(p,P(nn-1,xxx,l%u),-1);
    else if(i>ii)p=J(p,H(nn-1,xxx),-1);
  }
  console.log(p);
  return p;
}
console.log(P(3,2,0)); // [10,11,6]
console.log(P(3,2,3)); // [8,10,6]
console.log(P(3,2,1)); // [10,10,6]
console.log(P(3,2,2)); // [9,10,6]
P(3,2,4); // [3,1,0]
P(3,2,5); // [3,1,1]
P(3,2,6); // [3,2,1]
P(3,2,7); // [4,2,1]
P(3,2,8); // [4,2,2]
console.log(P(3,2,9)); // [6,8,4]
