N=8
console.log(BT(0,0,[]));

function BT(n,x,s){
  if(n==N && x==0) console.log(s.join(' '));
  if(n==N) return x?0:1;
  return (BT(n+1,x+1,[...s,x+1])+(x?BT(n+1,x-1,[...s,x-1]):0))%1000000007;
}