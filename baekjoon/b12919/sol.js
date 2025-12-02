[S,T]=(require('fs').readFileSync(0)+'').split('\n');
N=S.length;
F=a=>{
 let n=a.length;
 if(n==N) return a.join('')==S;
 return a[n-1]=='A'&&F(a.slice(0,n-1)) || a[0]=='B'&&F(a.slice(1).reverse());
}
console.log(F(T.split(''))?1:0)