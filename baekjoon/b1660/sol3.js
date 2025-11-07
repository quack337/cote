N=+(require('fs').readFileSync(0)+'');
Q=Array(N+1);Q[0]=0;Q[1]=1;
for(let i=2;i<=N;++i)Q[i]=Q[i-1]*2-Q[i-2]+i;
BS=x=>{
  let a=0,b=N;
  while(a<=b){
    m=(a+b)/2|0;
    if(Q[m]>x)b=m-1;else if(Q[m]<x)a=m+1;else return m;
  }
  return b;
}
M=Array(N+1);
BT=n=>{
  if(!n)return 0;
  if(M[n])return M[n];
  let x=n;
  for(let i=BS(n);i>0;--i){
    let t=BT(n-Q[i]);
    if(t<x)x=t;
  }
  return M[n]=x+1;
}
console.log(BT(N))