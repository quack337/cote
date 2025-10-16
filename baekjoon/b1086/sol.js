A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
N=A.shift();
K=A.pop();
M=Array(N+1).fill().map(e=>[]);
BT=(n,s)=>{
  if(n==N)return [];
  let bit=1<<n, a=BT(n+1,s), b= s&bit ? [] : BT(n+1,s+bit);
  if (s&bit==0){
  }
}
