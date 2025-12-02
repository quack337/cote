D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.trim().split(' ').map(e=>e+' '));
F=(a,b,l)=>{
 if(l<2)return l?A[a]:'';
 let n=B.indexOf(A[a],b)-b;
 return F(a+1,b,n)+F(a+1+n,b+n+1,l-n-1)+A[a]}
for(t=1;D[0][0]--;){
 N=D[t++][0];A=D[t++];B=D[t++];
 console.log(F(0,0,N))}