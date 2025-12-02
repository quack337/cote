// 백트래킹 구현
N=4;
for(K=1;K<=4;++K){
  A=[]; X = 0;
  F1(0);
  console.log(N, K, X, 1<<N);
}

function F1(n){
  if(n==N) return F2();
  for(let i=0;i<K;++i) {
    A[n]=i; F1(n+1);
  }
}
function F2(){
  let x=0, C=Array(K).fill(0);
  for(let i=0;i<N;++i)
    C[A[i]]++;
  for(let i=0;i<K;++i)
    x+=nCr(C[i],2);
  X += x;
  //console.log(C, x);
}
function nCr(n,r){
  if(r>n)return 0;
  if(n==1 || r==0)return 1;
  if(r==1)return n;
  return nCr(n-1,r-1) + nCr(n-1,r);
}
