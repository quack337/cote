let data = require('fs').readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => +data[idx++];
let N = getInt();
let A = [];
for (let i=0; i < N; ++i)
  A[i] = getInt();
let V = 1000; // 수열의 최대값
let M = Array(N+1).fill().map(e => Array(V+1).fill(-1));
DFS(0,0);
let prev = 0; // 역추적을 위한 prev 최초값
let S = []; // 역추적해서 찾은 수열을 담을 배열
for(let n=0; n < N; ++n) // n: 0부터 N-1까지 역추적
 if (M[n][prev] == M[n+1][A[n]]+1)
    // A[n] 항목을 선택하고 다음 단계 재귀호출 리턴값 + 1 == 이 단계 리턴값 이라면
    S.push(prev = A[n]) // 최장 수열  다음 단계는 A[n] 항목 선택 재귀호출이다
console.log(M[0][0] + '\n' + S.join(' '))

function DFS(n, prev) {
  if (n==N) return M[n][prev] = 0; // 경로 역추적 하려면, 모든 리턴값을 다 메모해야 한다
  if (M[n][prev] > -1) return M[n][prev];
  let a = A[n]>prev ? DFS(n+1, A[n]) + 1 : 0;
  let b = DFS(n+1, prev);
  return M[n][prev] = Math.max(a, b);
}