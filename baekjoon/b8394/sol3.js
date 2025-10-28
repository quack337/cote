N=+(require('fs').readFileSync(0)+'');
A=0;B=1;
while(N--){C=(B+A)%10;A=B;B=C;}
console.log(C);