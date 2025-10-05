// 통과했지만 다른 답들 보다 느리다.
// 음수 하나 제거하는 것을 여러 번 반복해서 sol2 호출하지 않고 그냥 한번반 반복해도 되나?
// 즉 제거하지 않은 경우 PQ와, 1개 제거한 경우 PQ 최대값 1개만 유지해도 되나?
// 그렇군!!
// 전체 PQ를 PQ1, 음수 제외 PQ를 PQ2라고 하자.
// 음수를 만날 때 마다 그 음수의 PQ2를 계산해서, 지금까지 유지한 PQ2 최대값 보다 크다면, 최대값만 가져가면 된다.
let A=(require('fs').readFileSync(0)+'').trim().split(/[\n\r\t ]+/).map(e=>+e);
let N=A.shift();
let P=Array(N), Q=Array(N), X=-Infinity;
sol();
A.reverse();
sol();
console.log(X);

function sol() {
  sol1();
  for (let j=(N/2)|0; j<N; ++j) // 나누기 2 소수점 버그 때문에 오래 삽질함.
    if (A[j]<0) sol2(j);
}

function sol1() { // 연속합 최대값 찾기
  P[0]=Q[0]=A[0];
  for (let i=1; i<N; ++i) {
    P[i] = (P[i-1]<0 ? 0 : P[i-1]) + A[i];
    Q[i] = P[i]>Q[i-1] ? P[i] : Q[i-1];
  }
  if (Q[N-1]>X) X=Q[N-1];
}

function sol2(j) { // j 항목을 빼고 연속합 최대값 찾기
  if (j==0) return; // 배열의 크기가 1인 경우는 뺄 수 없다.
  let p=P[j-1], q=Q[j-1];
  for (let i=j+1; i<N; ++i) {
    p = (p<0 ? 0:p) + A[i];
    q = p>q ? p:q;
  }
  if (q>X) X=q;
}