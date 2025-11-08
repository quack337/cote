D=(require('fs').readFileSync(0)+'').split('\n');
[R,C,K]=D.shift().split(' ').map(e=>+e);
W=D[R];N=W.length;
M=Array(R).fill().map(_=>Array(C).fill().map(_=>[]));
BT=(r,c,n)=>{
  let x=0,m=M[r][c];
  if(D[r][c]!=W[n])return m[n]=0;
  if(n==N-1)return m[n]=1;
  if(m[n]!=undefined)return m[n];
  for(let i=1;i<=K;++i){
    if(r-i>=0)x+=BT(r-i,c,n+1);
    if(r+i<R)x+=BT(r+i,c,n+1);
    if(c-i>=0)x+=BT(r,c-i,n+1);
    if(c+i<C)x+=BT(r,c+i,n+1);
  }
  return m[n]=x;
}
X=0;
for(let r=0;r<R;++r)
for(let c=0;c<C;++c)X+=BT(r,c,0);
console.log(X)