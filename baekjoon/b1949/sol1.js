D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];
V=D[1];
E=Array(N).fill().map(_=>[]);
for(let i=2;i<=N;++i){
  let[a,b]=D[i];
  E[--a].push(--b);E[b].push(a);
}
M=Array(N);
BT=(n,p)=>{
  //console.log(n,p);
  if (M[n]) return M[n];
  let C=E[n].filter(e=>e!=p);
  // 리턴 배열 [a, b, m]
  //  a: this노드를 선택하는 경우 리턴값
  //  b: this노드를 선택 안하는 경우 리턴값
  //  m: max(a, b)
  let a = V[n] + C.reduce((g,c)=>g+BT(c,n)[1], 0);
  // 자식중 적어도 하나 선택
  // 선택 자식 a값[0] 나머지 자식들 g값[2] 합계
  let b = C.length ? Math.max(...C.map(cs=> //cs자식선택
    C.reduce((g,c)=>g+BT(c,n)[c==cs?0:2], 0))) : 0;
  return M[n]=[a,b,Math.max(a,b)];
}
console.log(BT(0,0)[2]);

/* 반례
6
10 1 1 1 10 10
1 2
2 3
3 4
4 5
3 6

즉
위 구현은 부모 선택 여부를 무시하고 구현했음.
따라서 this를 선택하지 않은 경우에 무조건 자식들 중에 하나를 선택해야 하지만,
부모가 선택되었다면 자식들 중 하나를 선택하지 않아도 됨!
*/