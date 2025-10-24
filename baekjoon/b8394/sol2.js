// stackoverflow
N=+(require('fs').readFileSync(0)+'');
M=Array(N);
BT=n=>{
 if(n>N)return 0;
 if(n==N)return 1;
 if(M[n])return M[n];
 return M[n]=BT(n+1)+BT(n+2);
}
console.log(BT(0)%10)