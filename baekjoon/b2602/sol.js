D=(require('fs').readFileSync(0)+'').split('\n');
A=D.shift();
AN=A.length;BN=D[0].length;
M=Array(AN).fill().map(_=>Array(BN).fill().map(_=>[]));
BT=(a,b,d)=>{
  if(a==AN)return 1;
  if(b==BN)return 0;
  if(M[a][b][d]!=undefined)return M[a][b][d];
  let B=D[d],r=0;
  for(let i=b;i<BN;++i)
    if(B[i]==A[a])r+=BT(a+1,i+1,d?0:1);
  return M[a][b][d]=r;
}
console.log(BT(0,0,0)+BT(0,0,1));