// 연속구간합계 최대값 로직 응용: 시간초과
D=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e)
N=D.shift()
A=D.splice(0,N)
M=D.shift()
SP=[0]
SQ=[0]
P=[A[0]]
Q=[A[0]]
for(i=1;i<N;++i){
 if(P[i-1]>0) {SP[i]=SP[i-1]; P[i]=P[i-1]+A[i]}
 else {SP[i]=i; P[i]=A[i]}
 if(Q[i-1]>P[i]) {Q[i]=Q[i-1]; SQ[i]=SQ[i-1]}
 else {Q[i]=P[i]; SQ[i]=SP[i]}
}
X=[]
for(i=0;i<M;++i){
 a=D[i*2]-1; b=D[i*2+1]-1
 if(SQ[b]>=a) X.push(Q[b])
 else{
  p=q=A[a]
  for(j=a+1;j<=b;++j)q=Math.max(q,p=(p>0?p:0)+A[j])
  X.push(q)
 }
}
console.log(X.join('\n'))