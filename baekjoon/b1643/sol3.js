A=(require('fs').readFileSync(0)+'').trim().split('\n').map(e=>+e);O=[];
G=(a,b)=>b?G(b,a%b):a;
for(N of A){X=1,Y=1;
 for(let n=1;n<N;++n){
  [X,Y]=[X*(N-n),X*N+Y*(N-n)];
  g=G(X,Y);X/=g;Y/=g;}
 if(X==1)O.push(Y);else{
 b=(Y/X|0)+' ',a=' '.repeat(b.length);
 O.push(a+Y%X,b+'-'.repeat((X+'').length),a+X);}
}
console.log(O.join('\n'))