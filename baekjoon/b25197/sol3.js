// 조 인원 구성
[N,K]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
A=[]
F1=(j,n,k)=>{
  if(n==0){
    let B=A.slice(0,j);
    console.log(B, B.reduce((a,e)=>a+nCr(e,2),0), nPr(K, B.length));
    return;
  }
  let mx=Math.min(n,j?A[j-1]:n);
  let mn=Math.ceil(n/k);
  for(let i=mn;i<=mx;++i){
    A[j]=i; F1(j+1,n-i,k-1);
  }
}
nCr=(n,r)=>{
  if(r>n)return 0;
  if(n==1 || r==0)return 1;
  if(r==1)return n;
  return nCr(n-1,r-1) + nCr(n-1,r);
}
nPr=(n,r)=>{
  let x=1;
  for(let i=0;i<r;++i) x *= n-i;
  return x;
}
F1(0,N,K)