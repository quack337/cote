D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
X='';F=Infinity;
for(let i=1;;++i){
 if(!(N=D.shift()[0]))break;
 A=D.splice(0,N);
 M=Array(N).fill().map(_=>[]);
 X+=i+'. '+BT(0,1)+'\n';
}
console.log(X.trim());

function BT(r,c){
  if(r==N-1 && c==1)return A[r][1];
  if(M[r][c]!==undefined)return M[r][c];
  let x=Math.min(c<2?BT(r,c+1):F, r<N-1&&c>0?BT(r+1,c-1):F, r<N-1?BT(r+1,c):F, r<N-1&&c<2?BT(r+1,c+1):F);
  return M[r][c]=A[r][c]+x;
}