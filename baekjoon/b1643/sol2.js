A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
G=(a,b)=>{
  while(b){let c=a%b;a=b;b=c}
  return a;
}
for(let i=0;i<A.length;++i){
  N=A[i];X=1;Y=1;
  for(let n=1;n<N;++n){
    [X,Y]=[X*(N-n),X*N+Y*(N-n)]
    let g=G(X,Y);
    X/=g;Y/=g;
  }
  if(X==1)console.log(Y);
  else {let S=[,Y+' ',];
    S[0]=S[2]=Array(Array(S[1].length).fill(' ')
  console.log(Y/X|0, Y%X, X);
}
