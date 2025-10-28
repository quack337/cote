N=+(require('fs').readFileSync(0)+'');if(N<4)B=N-1;else{A=1;B=2;for(let n=4;n<=N;++n){C=(n-1)*(A+B)%1e9;A=B;B=C}}
console.log(B)