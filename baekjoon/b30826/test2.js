P=[,9,9];Q=[,10,10]; //0불가,0가능
for(let i=3;;++i){
  P[i]=9*Q[i-2];
  Q[i]=10*Q[i-2];
  if(P[i]>1e16)break;
}
N=(25-1); // 0부터 시작
for(i=1;;++i)
  if(N>=(P[i]*i)) N-=(P[i]*i);
  else break;
console.log(i, N)