[X,L,R,N]=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
C=[,[1,3,2],[2,1,1],[2,3,2]];
M=Array(N+1).fill().map(_=>[]);
M[0]=[,[1,0,0],[0,1,0],[0,0,1]];
M[1]=[,[1,1,1],[2,1,0],[0,2,1]];
E=n=>{for(let i=1;i<=20;++i)if(n<=3**i)return i}
J=(a,b,c)=>[a[0]+b[0]+c[0],a[1]+b[1]+c[1],a[2]+b[2]+c[2]];
G=(a,b,c)=>[a[0]-b[0]-c[0],a[1]-b[1]-c[1],a[2]-b[2]-c[2]];
K=(n,x,o)=>{
  //console.log('K', n,x,o);
  if(!n)return x;
  if(!o){
    if(x==1) return 1;
    if(x==2) return 2;
    if(x==3) return 2;
  } else{
    if(x==1) return n%2?2:1;
    if(x==2) return n%2?1:2;
    if(x==3) return n%2?1:2;
  }
}
H=(n,x)=>{
  if(M[n][x])return M[n][x];
  return M[n][x] = x==1? J(H(n-1,1),H(n-1,3),H(n-1,2)) :
    x==2? J(H(n-1,2),H(n-1,1),H(n-1,1)) : J(H(n-1,2),H(n-1,3),H(n-1,2));
}
F=(n,x,l,r)=>{
  console.log(n,x,l,r);
  if(n<2){
    let y=[0,0,0];
    if(!n)y[x-1]=1;
    else for(let i=l;i<=r;++i)y[C[x][i]-1]++;
    //console.log(x,C[x],l,r,y);
    return y;
  }
  let el=E(l), p=l?F(el,K(n-el,x,0),0,l-1):[0,0,0];
  //if(n==3) console.log(p,el,K(n-el,x,0),l-1);
  let q, rr=3**n-1-r, er=E(rr);
  if(rr) {
    q=F(er,K(n-er,x,1),r-(3**n-3**er)+1,3**er-1);
    //if(n==3) console.log(q,rr,er,K(n-er,x,1),r-(3**n-3**er),3**er-1);
  } else q=[0,0,0];
  return G(H(n,x),p,q);
}
console.log(F(N,X,L,R).join(' '))