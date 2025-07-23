let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let N = getInt(), R = getInt();
let A = []; // 입력으로 주어진 수 목록
let S = []; // 지금까지 선택한 수 목록
let V = []; // 인덱스 i 위치의 수를 선택했는지 표시하기 위한 배열. 중복 선택을 막기 위함.
let answer = new Set(); // 수를 선택해서 만든 정수를 담을 Set 객체. 중복된 값이 자동으로 걸러진다
for (let i = 0; i < N; ++i)
  A[i] = getStr(); // 선택한 수들을 문자열 연결할 거라고 정수로 변환하지 않는다
DFS(0);
console.log(answer.size); // Set 객체 담긴 정수의 갯수를 출력한다

function DFS() {
  if (S.length == R) { // R개를 선택했다면
    // 선택한 수들을 연결하여 문자열을 만들고, 정수로 변환한다
    let n = parseInt(S.join(''));
    answer.add(n);
    return;
  }
  for (let i = 0; i < N; ++i)
    if (!V[i]) { // 인덱스 i 위치의 값을 아직 선택하지 않았다면
      V[i] = true; // i 위치의 값을 선택했다고 표시
      S.push(A[i]); // 선택한 수 목록에 A[i] 추가
      DFS();         // 재귀호출
      V[i] = false; // 재귀호출에서 리턴하자 마자 A[i] 선택을 취소한다
      S.pop();
    }
}
