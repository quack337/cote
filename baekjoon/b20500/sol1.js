for(let n=1; n<=15; ++n) {
  X=0;BT(n,0);
  console.log(n, X);
}

function BT(n,x){
  if(n==0){
    if(x%15==0)++X;
    return;
  }
  BT(n-1,x*10+1);
  BT(n-1,x*10+5);
}