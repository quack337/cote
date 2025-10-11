D=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
T=D[0];
M=Array(65).fill().map(_=>[]);
M[0]=Array(10).fill(1);
BT=(n,p)=>{
  if(M[n][p])return M[n][p];
  let s=0;
  for(let i=p;i<=9;++i)s+=BT(n-1,i);
  return M[n][p]=s;
}
X='';
for(let t=1;t<=T;++t)X+=BT(D[t],0)+'\n';
console.log(X);