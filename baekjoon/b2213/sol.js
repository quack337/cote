D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];
W=D[1];
E=Array(N).fill().map(_=>[]);
for(let i=2;i<=N;++i){ [a,b]=D[i]; E[--a].push(--b);E[b].push(a); }
M=Array(N).fill().map(_=>[]);
BT=(n,p,s)=>{
  if(M[n][s]!=undefined)return M[n][s];
  let a=0,b=!s?W[n]:0;
  for(let i=0;i<E[n].length;++i){
    let c=E[n][i];
    if(c!=p){ a+=BT(c,n,0); if(!s)b+=BT(c,n,1);};
  }
  return M[n][s]=Math.max(a,b);
}
X=BT(0,0,0);
Y=[];
B2=(n,p,s)=>{
  let a=0,b=!s?W[n]:0;
  for(let i=0;i<E[n].length;++i){
    let c=E[n][i];
    if(c!=p){ a+=M[c][0]; if(!s)b+=M[c][1];};
  }
  if(b>a)Y.push(n+1);
  for(let i=0;i<E[n].length;++i){
    let c=E[n][i];
    if(c==p)continue;
    if(b>a)B2(c,n,1); else B2(c,n,0);
  }
}
B2(0,0,0);
Y.sort((a,b)=>a-b);
console.log(X+'\n'+Y.join(' '));