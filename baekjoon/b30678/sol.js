F=n=>{
let e=n--?F(n):['*'],u=5**n,s=' '.repeat(u),x=[]
for(i=0;i<u;++i){
x[i]=x[u+i]=s+s+e[i]+s+s;
x[u*2+i]=e[i].repeat(5);
x[u*3+i]=s+e[i].repeat(3)+s;
x[u*4+i]=s+e[i]+s+e[i]+s}
return x}
console.log(F(+(require('fs').readFileSync(0)+'')).join('\n'))