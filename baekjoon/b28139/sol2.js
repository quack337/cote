A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=A.shift(0)[0];
X=0;Y=0;
for(let i=0;i<N-1;++i)
for(let j=i+1;j<N;++j){
  let a=A[i],b=A[j],x=a[0]-b[0],y=a[1]-b[1];
  X+=Math.sqrt(x*x+y*y);++Y;
}
console.log(X/Y*(N-1))