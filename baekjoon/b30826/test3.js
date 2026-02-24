P=[,9,9];Q=[,10,10]; //0불가,0가능
for(let i=3;;++i){
  P[i]=9*Q[i-2];
  Q[i]=10*Q[i-2];
  if(P[i]>1e16)break;
}
N=(25-1); // 0부터 시작
for(d=1;;++d)
  if(N>=(P[d]*d)) N-=(P[d]*d);
  else break;
console.log(`${d} 자리 수들이 붙어있는 목록에서 ${N} 위치 문자`);
n = (N/d)|0;
i = N%d;
console.log(`${d} 자리 수들 중에서 ${n+1} 번째 수의 ${i} 위치 문자`);
