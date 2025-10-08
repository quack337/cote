N=+(require('fs').readFileSync(0)+'');
M1=0;
M2=1;
D=1000000000;
if(N>0) for(let i=2;i<=N;++i){t=M2; M2=(M2+M1)%D; M1=t;}
else for(let i=-1;i>=N;--i){t=M1; M1=(M2-M1)%D; M2=t;}
X=N>0?M2:M1;
console.log(!X?'0\n0':X>0?'1\n'+X:'-1\n'+(-X));