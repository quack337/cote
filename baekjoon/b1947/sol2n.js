N=+(require('fs').readFileSync(0)+'');
if(N<4){console.log(N-1);return}
A=1n;B=2n;
for(let n=4n;n<=N;++n){
  C=(n-1n)*(A+B)%1000000000n;
  A=B;B=C;
}
console.log(C+'');