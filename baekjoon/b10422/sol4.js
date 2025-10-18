// logic.txt 수열 목록을 보고 로직을 새로 만들어 구현
// 계산은 맞는 거 같다.
for(N=1; N<=30; ++N){
  M=Array(N).fill().map(e=>[]);
  console.log(BT(0,0));
}

function BT(n,p){
  if (n==N) return 1;
  if(M[n][p])return M[n][p];
  let r=0;
  for (let i=p+1; i>=1; --i)
    r+=BT(n+1,i);
  return M[n][p]=r;
}
