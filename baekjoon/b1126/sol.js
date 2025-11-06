A=[2,4,6];N=3;
X=[0,0,1,0,1,0,1,0,1,0,1,0,1,0];
for(let i=0;i<X.length;++i)
  console.log(i, BT(0,i));

function BT(n,h){
  if(h<0)return 0;
  if(h==0)return 1;
  if(n==N)return 0;
  return BT(n+1,h)+BT(n+1,h-A[n]);
}