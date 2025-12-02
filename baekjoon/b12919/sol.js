[S,T]=(require('fs').readFileSync(0)+'').split('\n').map(e=>e.trim());
N=S.length;
F=(n,a)=>{
  if(n==N) return a.join('')==S;
  return (a[n-1]=='A' && F(n-1, a.slice(0,n-1))) || 
         (a[0]=='B' && F(n-1, a.slice(1).reverse()));
}
console.log(F(T.length, T.split(''))?1:0)