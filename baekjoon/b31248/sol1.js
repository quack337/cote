N=+(require('fs').readFileSync(0)+'').trim();
X=[];
F=(n,a,b,c)=>{
 if(n==1)return X.push(a+' '+c);
 F(n-1,a,c,b);
 F(1,a,b,c);
 F(n-1,b,a,c);
}
F(N,1,2,3);
console.log(X.join('\n'))