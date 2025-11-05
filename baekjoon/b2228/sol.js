A=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
[N,M]=A.shift();
BT=(n,m)=>{
  if(!m)return 0;
  if(n==N)return -Infinity;
  let x = -Infinity;
  for(let a=n;a<N-2;++a){
    let sum = A[a];
    for (let b=a+2;b<N;sum+=A[b-1],++b){
      let t = sum + 
}
