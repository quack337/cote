let A=require('fs').readFileSync(0).toString().split('\n').map(e=>+e);
let T=A.shift();
let M=[0,1,2,4];
for (let i=4; i<=1_000_000; ++i)
  M[i] = (M[i-1]+M[i-2]+M[i-3]) % 1_000_000_009;
let X=[];
for (let t=0; t<T; ++t)
  X.push(M[A[t]]);
console.log(X.join('\n'));
