D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];
V=D[1];
E=Array(N).fill().map(_=>[]);
for(let i=2;i<=N;++i){
  let[a,b]=D[i];
  E[--a].push(--b);E[b].push(a);
}
M=Array(N).fill().map(_=>[0,0]);
BT=(n,p,s)=>{ //s: 부모 선택되었나
  if (M[n][s]) return M[n][s];
  let C=E[n].filter(e=>e!=p);
  // 리턴 배열 [a, b, m]
  //  a: this노드를 선택하는 경우 리턴값
  //  b: this노드를 선택 안하는 경우 리턴값
  //  m: max(a, b)
  let a = s ? 0 : V[n] + C.reduce((g,c)=>g+BT(c,n,1)[1], 0);
  // 자식중 적어도 하나 선택
  // 선택 자식 a값[0] 나머지 자식들 g값[2] 합계
  let b = s ? C.reduce((g,c)=>g+BT(c,n,0)[2], 0) :
    C.length ? Math.max(...C.map(cs=> //cs자식선택
      C.reduce((g,c)=>g+BT(c,n,0)[c==cs?0:2], 0))) : 0;
  return M[n][s]=[a,b,Math.max(a,b)];
}
console.log(BT(0,0,0)[2]);
