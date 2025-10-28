function BT(n){
  if(n>N) return 0;
  if(n==N) return 1;
  return BT(n+1)+BT(n+2);
}

for(N=1; N<=10; ++N)
  console.log(N, BT(0));
