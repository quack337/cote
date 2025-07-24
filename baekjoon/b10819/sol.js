let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => parseInt(input[idx++]);
let N = getInt(), A = [];
for (let i = 0; i < N; ++i)
  A[i] = getInt();
let S = []; // 지금까지 선택한 선택한 숫자 목록
let V = []; // 인덱스 i 위치의 수를 선택했는지 표시하기 위한 배열. 중복 선택을 막기 위함
let 답 = 0;
DFS();
console.log(답);

function DFS() {
  if (S.length == N) { // N개를 선택했다면
    let sum = 0; // 문제가 요구한 계산식을 계산한다
    for (let i = 0; i < N-1; ++i)
      sum += Math.abs(S[i] - S[i+1]);
    if (sum > 답) 답 = sum; // 최대값 찾기
    return;
  }
  for (let i = 0; i < N; ++i)
    if (!V[i]) { // 인덱스 i 위치의 수를 아직 선택하지 않았다면
      V[i] = true;  // 인덱스 i 위치의 수를 선택했다고 표시
      S.push(A[i]); // 인덱스 i 위치의 수를 선택 목록에 추가
      DFS(); // 재귀호출
      V[i] = false; // 재귀호출에러 리턴하자 마자 인덱스 i 위치의 수 선택을 취소한다
      S.pop();
    }
}
