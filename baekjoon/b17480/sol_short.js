X=new Set();
F=(s,l,r,p,q)=>{
 for(;l<r;++l,--r)[s[l],s[r]]=[s[r],s[l]];
 if(q-p<2)X.add(s.join(''));else{
 let m=(p+q)/2|0;
 F([...s],p,m,m+1,q);F([...s],m+1,q,p,m);
 if((q-p)%2==0){F([...s],p,m-1,m,q);F([...s],m,q,p,m-1)}}}
D=(require('fs').readFileSync(0)+'').split('\n');
A=D[1].split(' ');S=D[2].split('');C=Array(26).fill(0);
I=c=>c.charCodeAt(0)-97;
for(i=0;i<A.length;)C[I(A[i++])]=+A[i++];
N=C.reduce((a,b)=>a+b);
for(i=0;i<S.length;++i){
 C[I(S[i])]--;if(i>=N)C[I(S[i-N])]++;
 if(C.every(e=>!e))F(S.slice(i-N+1,i+1),0,0,0,N-1)}
console.log(X.size)