// sol5.js 에서 구현한 로직에 해당하는 수열 목록 출력해 보기
N=6;
BT(0,0,[]);

function BT(n,p,s){
  if (n==N) { console.log(s.join('')); return; }
  for (let i=p+1; i>=1; --i)
    BT(n+1,i,[...s,i]);
}
