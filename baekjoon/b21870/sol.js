A=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
N=A.shift();
E=(a,b)=>b?E(b,a%b):a
G=(a,b)=>A.slice(a,b+1).reduce((a,b)=>E(a,b));
F=(a,b)=>{
 let c=b-a;
 if(c<2)return A[a]+(c?A[b]:0);
 c=++c>>1;
 return Math.max(G(a,a+c-1)+F(a+c,b),F(a,a+c-1)+G(a+c,b));
}
console.log(F(0,N-1))