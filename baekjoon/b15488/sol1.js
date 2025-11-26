[N,r,c,K]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
M=Array(N).fill().map(_=>Array(N).fill().map(_=>[]));
D=[[1,2],[-1,2],[1,-2],[-1,-2],[2,1],[-2,1],[2,-1],[-2,-1]];
BT=(r,c,k)=>{
  if(r<0||r>=N||c<0||c>=N)return 0;
  if(M[r][c][k])return M[r][c][k];
  if(!k)return M[r][c][k]=1;
  let x=0;
  for(let i=0;i<8;++i)x+=BT(r+D[i][0],c+D[i][1],k-1);
  return M[r][c][k]=x/8;
}
console.log(BT(r-1,c-1,K))