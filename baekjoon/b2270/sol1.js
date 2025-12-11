D=(require('fs').readFileSync(0)+'').trim().split('\n').map(s=>s.trim().split(' ').map(e=>+e));
N=D.shift()[0];
B=[]
for(i=1;i<4;++i)for(j of D[i])B[j]=i;
O=(n,a,c)=>console.log(n, a+'-'+c);
H=(n,a,b,c)=>{ // 하노이
  // console.log(n,a,b,c);
  if(n==1)return O(1,a,c);
  H(n-1,a,c,b);
  O(n,a,c);
  H(n-1,b,a,c);
}
F=(n,c)=>{
  // console.log(n,c);
  // a에 있는 n과 그 이하들을 c에 모은다
  if(!n)return;
  let a=B[n],b=6-c-a;
  if(a==c)return F(n-1,c);
  if(n==1)return O(1,a,c);
  // 먼저 n-1 이하들을 b에 모은다. 그 다음 n을 c로 이동.
  F(n-1,b);
  O(n,a,c);
  H(n-1,b,a,c);
}
c=B[N];
for(n=N-1;n>=0;--n)
  if(B[n]!=c){F(n,c);break}

