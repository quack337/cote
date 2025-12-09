A=(require('fs').readFileSync(0)+'').trim().split(/\s+/).map(e=>+e);
N=A.shift();X=[];
A.sort((a,b)=>a-b);
F=(a,b)=>{if(a<=b){let m=(a+b)/2|0;F(a,m-1);F(m+1,b);X.push(A[m])}}
F(1,N);
console.log(X.join(' '))