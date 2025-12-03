N=(require('fs').readFileSync(0)+'');
L=[3];
F=_=>{
 if(N<=L[0])return G(0);
 for(let i=1;;++i)if(N<=(L[i]=L[i-1]*2+i+3))return G(i)}
G=i=>{
 if(N<4)return"moo"[N-1];
 if(N<=L[i-1])return G(i-1);
 if((N-=L[i-1])==1)return'm';
 return(N-=i+3)<=0?'o':G(i-1)}
console.log(F())