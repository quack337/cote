D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[R,C]=D[0];
K=D[1][0];
Z=[]
for(let i=0;i<K;++i){
  let [v,w,x,y]=D[i+2];
  let r1=v<x?v:x, c1=w<y?w:y;
  let r2=v>x?v:x, c2=w>y?w:y;
  Z.push([r1, c1, r2, c2]);
}
WZ=(r1,c1,r2,c2)=>{
  for(let i=0; i<Z.length; ++i)
    if(r1==Z[i][0] && c1==Z[i][1] && r2==Z[i][2] && c2==Z[i][3]) return true;
  return false;
}
M=Array(R+1).fill().map(_=>Array(C+1));
BT=(r,c)=>{
  if(r==R && c==C) return 1n;
  if(M[r][c]!=undefined)return M[r][c];
  let x=0n;
  if(r<R && !WZ(r,c,r+1,c)) x+=BT(r+1,c);
  if(c<C && !WZ(r,c,r,c+1)) x+=BT(r,c+1);
  return M[r][c]=x;
}
console.log(BT(0,0)+'')
