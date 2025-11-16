D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.trim().split(' ').map(e=>+e));
M=D[0][0];
A=D[1];
R=D[2][0];
N=A.reduce((a,b)=>a+b);
FN=a=>{
 if(a<R)return 0;
 let r=1;for(let i=0;i<R;++i)r*=a-i;
 return r;
}
console.log(A.reduce((a,b)=>a+FN(b),0)/FN(N))