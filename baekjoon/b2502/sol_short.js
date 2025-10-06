I=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
let[D,K]=I;
A1=B2=1;A2=B1=0;
for(i=3;i<=D;++i){a=A2;b=B2;A2=A2+A1;B2=B2+B1;A1=a;B1=b;}
b=Math.ceil(K/(A2+B2));
for(;;++b)if((k=K-B2*b)%A2==0)break;
console.log(k/A2+'\n'+b);