D=(require('fs').readFileSync(0)+'').split('\n');
[N,M]=D.shift().split(' ').map(e=>+e);
A=D.map(e=>+e);
P=Array(N).fill().map(_=>Array(2).fill().map(_=>[]));
BT=(n,m,p)=>{
  if(m==0)return 0;
  if(n>=N)return p&&m==1?0:-Infinity;
  if(P[n][p][m]!=undefined)return P[n][p][m];
  let a = p ? BT(n+1,m-1,0) : BT(n+1,m,0); // 선택 안하는 경우
  let b = BT(n+1,m,1) + A[n]; // 선택하는 경우
  return P[n][p][m] = a>b ? a : b;
}
console.log(BT(0,M,0));