// 통과
D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
T=D.shift()[0];
X='';
for (let t=0; t<T; ++t){
  [N,W] = D[t*3];
  A=[D[t*3+1],D[t*3+2]];
  M=Array(N).fill().map(e=>Array(3).fill().map(e=>[]));
  X+=N*2-BT(0,0,0)+'\n';
}
console.log(X);

function BT(n,p,s){
  if(n>=N)return 0;
  if(M[n][p][s]!=undefined) return M[n][p][s];
  let a = A[0][n]+A[1][n]<=W;
  let b = n<N-1 ? A[0][n]+A[0][n+1]<=W : (n>1?A[0][n]+A[0][0]<=W:0);
  let c = n<N-1 ? A[1][n]+A[1][n+1]<=W : (n>1?A[1][n]+A[1][0]<=W:0);
  let x;
  if(n==N-1){
    if(p==0)
      x = Math.max(
        a && 1,
        s==0 && b && c && 2,
        (s==0||s==2) && b && 1,
        (s==0||s==1) && c && 1);
    else if(p==1)
      x = (s==0||s==1) && c && 1;
    else // if(p==2)
      x = (s==0||s==2) && b && 1;
  } else if(n==0)
      x = Math.max(
        BT(n+1,0,0),
        a && BT(n+1,0,3)+1,
        b && c && BT(n+2,0,3)+2,
        b && BT(n+1,1,1)+1,
        c && BT(n+1,2,2)+1);
  else
    if(p==0)
      x = Math.max(
        BT(n+1,0,s),
        a && BT(n+1,0,s)+1,
        b && c && BT(n+2,0,s)+2,
        b && BT(n+1,1,s)+1,
        c && BT(n+1,2,s)+1);
    else if(p==1)
      x = Math.max(
        BT(n+1,0,s),
        c && BT(n+1,2,s)+1);
    else // if(p==2)
      x = Math.max(
        BT(n+1,0,s), //?
        b && BT(n+1,1,s)+1);
  return M[n][p][s]=x;
}