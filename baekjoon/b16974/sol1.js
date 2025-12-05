[N,X]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
L=[1];S=[1];
for(i=1;i<=N;++i){L[i]=L[i-1]*2+3;S[i]=S[i-1]*2+1;}
F=(n,x)=>{
  if(!n)return x>0?1:0;
  if(x<2)return 0;
  let c=x>L[n-1]?S[n-1]:F(n-1,x-1);
  if(x>L[n-1]+1){
    ++c;
    if(x>L[n-1]+2) c+=F(n-1,x-2-L[n-1]);
  }
  return c;
}
console.log(F(N,X))