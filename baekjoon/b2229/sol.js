A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
N=A.shift();
M=Array(N);
BT=n=>{
  if(n==N)return 0;
  if(M[n]!=undefined)return M[n];
  let a=A[n],b=a,r=0,x;
  for(let i=n;i<N;++i){
    x=A[i];if(x<a)a=x;else if(x>b)b=x;
    r=Math.max(r,BT(i+1)+b-a);
  }
  return M[n]=r;
}
console.log(BT(0));