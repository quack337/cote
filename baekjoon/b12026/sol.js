D=(require('fs').readFileSync(0)+'').split('\n');
N=+D[0];A=D[1];M=Array(N);
BT=n=>{
  if(n==N-1)return 0;
  if(M[n]!=undefined)return M[n];
  let c=A[n]=='B'?'O':A[n]=='O'?'J':'B', x=Infinity;
  for(let i=n+1;i<N;++i)
    if(A[i]==c) 
      x=Math.min(x,BT(i)+(i-n)*(i-n));
  return M[n]=x;
}
x=BT(0);
console.log(x==Infinity?-1:x);