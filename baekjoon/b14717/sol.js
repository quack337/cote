[a,b]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
F=(a,b)=>a==b?10+a:(a+b)%10;
v=F(a,b);
W=0,A=0;
for(let i=1;i<11;++i)if(i!=a)
for(let j=1;j<11;++j)if(j!=b){
  ++A;
 if(v>F(i,j))++W;
}
console.log(A,W);
console.log(W/A)