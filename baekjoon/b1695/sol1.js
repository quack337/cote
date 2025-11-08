D=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
N=D.shift();
M=Array(N).fill().map(_=>Array(N));
BT=(a,b)=>{
  if(a>=b)return 0;
  if(M[a][b]!=undefined)return M[a][b];
  if(D[a]==D[b])return BT(a+1,b-1);
  let x=BT(a+1,b),y=BT(a,b-1);
  return M[a][b]=(x<y?x:y)+1;
}
console.log(BT(0,N-1))