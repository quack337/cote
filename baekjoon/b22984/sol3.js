D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
A=D[1];
a=b=0;
for(let n=D[0][0]-1; n>0; --n){
  let p=A[n],q=1-p, t=(b+2)*p+a*q;
  b=(b+1)*p+(a+1)*q; a=t;
}
console.log(a*(1-A[0])+(b+1)*A[0])