A=(require('fs').readFileSync(0)+'').trim().split('\n').map(e=>+e);O=[];
G=(a,b)=>{let c;while(b){c=a%b;a=b;b=c}return a;}
for(let i=0;i<A.length;++i){
 N=A[i];X=1;Y=1;
 for(let n=1;n<N;++n){
  [X,Y]=[X*(N-n),X*N+Y*(N-n)];
  let g=G(X,Y);X/=g;Y/=g;
 }
 if(X==1)O.push(Y);else{
  let b=(Y/X|0)+' ',a=' '.repeat(b.length),c=a;
  b+='-'.repeat((X+'').length);a+=Y%X;c+=X;
  O.push(a,b,c);
 }
}
console.log(O.join('\n'))