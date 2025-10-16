A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
N=A.shift();
M=Array(N+2).fill(0);
X=0;
for(let i=N-1;i>=0;--i){
 let x=A[i];
 M[x]=M[x+1]+1;
 if(M[x]>X)X=M[x];
}
console.log(N-X);