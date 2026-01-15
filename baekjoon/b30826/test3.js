P=[,9,9];Q=[,10,10]; //0불가,0가능
for(let i=3;;++i){
  P[i]=9*Q[i-2];
  Q[i]=10*Q[i-2];
  if(P[i]>1e16)break;
}
N=25;
for(d=1;;++d)
  if(N>=P[d]) N-=P[d];
  else break;
console.log("d:%d N:%d", d, N);
console.log("1자리 9개, 2자리 9개, N=25-9-9=7, d=3자리 목록에서 7번째는?");
e1=N/d|0,e2=N%d;
console.log("e1=N/d=%d e2=N%%d=%d", e1, e2);
console.log("%d자리수 목록에서 e1=%d개는 제외하고, e1+1=%d번째 %d자리 수에서 e2=%d번째 문자는?", 
  d, e1, e1+1, d, e2);
