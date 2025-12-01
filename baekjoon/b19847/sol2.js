D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];T=A[0];
X=Array(A[0]).fill(1);
for(let i=1;i<N;++i){
 let a=A[i]; if(a>=T)continue;
 for(let i=a;i<T;++i)X[i%a]+=X[i];
 T=a;
}
X=X.slice(0,T)
console.log(X.reduce((a,e,i)=>i*e+a,0)/X.reduce((a,b)=>a+b))