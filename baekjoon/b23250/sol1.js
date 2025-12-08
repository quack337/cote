[N,K]=(require('fs').readFileSync(0)+'').trim().split(' ').map(e=>+e);
I=0;
F=(n,a,b,c)=>{
  if(n==1) return ++I==K?console.log(a, c):0;
  F(n-1,a,c,b);
  F(1,a,b,c);
  F(n-1,b,a,c);
}
F(N,1,2,3)