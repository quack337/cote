let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getStr = () => input[idx++];
let A = []; // 입력으로 주어진 2차원 배열
let ROW = 5, COL = 5; // 5행 5열
for (let r = 0; r < ROW; ++r)
  A[r] = getStr().split(''); // 입력으로 주어진 2차원 배열
let S = []; // 지금까지 선택한 좌표 목록
let N = ROW * COL; // 5행 5열의 좌표 갯수 == 25
let R = 7; // 7개의 좌표를 선택해야 한다
let 답 = 0;
DFS(0, N-R, 0); // N==25개의 좌표에서 R==7개를 선택해야 한다
console.log(답);

function DFS(from, to, count) { // count: 지금까지 선택한 좌표 갯수
  if (count == R) { // R개를 선택했다면
    if (isValid()) ++답; // 선택한 7개의 좌표가 문제의 조건을 만족하면 ++답
    return;
  }
  for (let i = from; i <= to; ++i) {
     // i 번째 좌표를 S 목록에 추가하기 위해, i값으로부터 행, 열 좌표를 계산한다
    let c = i % COL, r = (i-c) / COL;
    S[count] = [r, c]; // i 번째 좌표를 S 목록에 추가
    DFS(i+1, to+1, count+1);  // 재귀호출
            // 선택한 갯수가 count 변수로 유지되기 때문에 S.pop() 할 필요 없다.
            //   재귀호출될 때 count 값이 count+1 되지만
            //   재귀호출에서 리턴하면 count 값은 재귀호출 전의 count 값 그대로이다
  }
}

// 선택한 7개의 좌표가 문제의 조건을 만족하는지 확인한다
function isValid() {
  let count = 0; // 'S' 문자의 수를 센다
  let B = A.map(() => []); // 7개의 좌표가 연결 그래프인지 확인하기 위한 2차원 배열 생성
  for (let [r,c] of S) { // 선택된 7개의 좌표 각각에 대해서
    B[r][c] = 1; // 선택된 좌표에 1 표시한다
    if (A[r][c] == 'S') ++count; // 선택된 좌표의 'S' 문자 수를 센다
  }
  if (count < 4) return false; // 'S' 문자가 4개 이상이어야 한다

  count = 0; // 연결 그래프의 크기를 확인하기 위해 count 변수를 0으로 초기화한다
             // isValid 함수 내부에 DFS 함수에서
             // isValid 함수의 지역 변수인 count를 사용할 수 있다

  let [r, c] = S[0]; // 첫번째 좌표에서 시작하는
  DFS(r, c);         // 연결 그래프의 크기를 구한다
  return count == 7; // 연결 그래프의 크기가 7이어야 한다. 즉 7개 좌표가 모두 인접해있어야 한다

  function DFS(r, c) { // DFS 함수는 isValid 함수의 내부 함수이다
    if (B[r][c] != 1) return; // isValid 함수의 지역변수 B를 사용할 수 있다
    B[r][c] = 0;
    ++count; // 연결 그래프의 크기를 센다
    if (r > 0) DFS(r-1, c);
    if (c > 0) DFS(r, c-1);
    if (r < ROW-1) DFS(r+1, c);
    if (c < COL-1) DFS(r, c+1);
  }
}
