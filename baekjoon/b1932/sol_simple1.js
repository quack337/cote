// 백트레킹만 구현 - 시간초과
let data = require('fs').readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => +data[idx++];
let N = getInt();
let A = Array(N).fill().map(() => []);
for (let r=0; r < N; ++r)
  for (let c=0; c <= r; ++c)
    A[r][c] = getInt();
console.log(DFS(0,0));
console.log(A);

function DFS(r,c) {
  if (r==N-1) return A[r][c]; // 리프 노드에 도착하면 노드의 값 리턴
  let a = DFS(r+1, c); // 왼쪽 자식을 선택한 경우 리턴값
  let b = DFS(r+1, c+1); // 오른쪽 자식을 선택한 경우 리턴값
  return Math.max(a, b) + A[r][c]; // 두 리턴값 중 최대값 + 이 노드의 값
}