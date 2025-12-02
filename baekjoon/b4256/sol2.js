D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.trim().split(' ').map(e=>+e))
F=(a,b,l)=>{
 if(l<2)return l&&[,A[a]]
 let n=B.indexOf(A[a],b)-b;
 return[F(a+1,b,n),A[a],F(a+1+n,b+n+1,l-n-1)]}
P=a=>a?P(a[0])+P(a[2])+a[1]+' ':'';
for(t=1;D[0][0]--;){
 N=D[t++][0];A=D[t++];B=D[t++];
 console.log(P(F(0,0,N)).trim())}