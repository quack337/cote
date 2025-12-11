D=(require('fs').readFileSync(0)+'').trim().split('\n').map(s=>s.trim().split(' ').map(e=>+e));
N=D.shift()[0];B=[];X=0;
for(i=1;i<4;++i)for(j of D[i])B[j]=i;
F=(n,c)=>{
 if(!n)return;
 let a=B[n],b=6-c-a;
 if(a==c)return F(n-1,c);
 if(n==1)return X=(X+1)%1e6;
 F(n-1,b);
 // X += 1 + 하노이(2**(n-1)-1)
 X=(X+Number((1n<<BigInt(n-1))%1000000n))%1e6}
c=B[N];
for(n=N-1;n>=0;--n)if(B[n]!=c){F(n,c);break}
console.log(c+'\n'+X)
