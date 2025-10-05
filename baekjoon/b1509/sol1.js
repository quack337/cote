// 반례: AABDBA
// AA BDB A
// 앞에서 AA를 선택하니 ABDBA를 찾지 못한다.
// 결국 짜르는 것도 모든 것을 다 시도해야함
let S=(require('fs').readFileSync(0)+'').trim().split('');
let N=S.length, X=0, i=0;
for (let i=0; i<N; ++X) {
  let f=i;
  i = sol(i);
  console.log(S.slice(f,i).join(''));
}
console.log(X);

function sol(i) {
  for (let j=N-1; j>i; --j)
    if (BT(i,j)) return j+1;
  return i+1;
}

function BT(a,b) {
  return a==b || (S[a]==S[b] && (a+1==b || BT(a+1,b-1)));
}
