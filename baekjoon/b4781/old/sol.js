A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
BT=(n,m)=>{
  if(n==N)return 0;
  if(DP[n][m*100]!=undefined)return DP[n][m*100];
  let[c,p]=A[n],x=0;
  for(let cc=0,pp=0;pp<=m;cc+=c,pp+=p)
    x = Math.max(x, BT(n+1,m-pp)+cc);
  return DP[n][m*100]=x;
}
X='';
for(;;){
  [N,M]=A.shift();
  if(!N)break;
  DP=Array(N).fill().map(_=>[]);
  X+=BT(0,M)+'\n';
  A=A.slice(N);
}
console.log(X);