// logic.txt 수열 목록을 보고 로직을 만들어 구현
// 이것도 시간초과겠다..
N=2000;
M=Array(N).fill().map(e=>[]);
console.log(BT(0,0));

function BT(n,p){
  if (n==N) return 1;
  if(M[n][p])return M[n][p];
  let r=0;
  for (let i=p+1; i>=1; --i)
    r=(r+BT(n+1,i))%1000000007;
  return M[n][p]=r;
}
