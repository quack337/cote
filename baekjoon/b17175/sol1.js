for(N=0;N<=20;++N)
  console.log(N,BT(N));

function BT(n){
  if(n<2)return 1;
  return BT(n-2)+BT(n-1)+1;
}