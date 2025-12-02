// 조 인원 구성
[N,K]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
A=[]
F1=(j,n,k)=>{
  if(n==0){
    console.log(A.slice(0,j))
    return;
  }
  let mx=Math.min(n,j?A[j-1]:n);
  let mn=Math.ceil(n/k);
  for(let i=mn;i<=mx;++i){
    A[j]=i; F1(j+1,n-i,k-1);
  }
}
F1(0,N,K)