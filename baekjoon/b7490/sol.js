let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => parseInt(data[idx++]);
const OP = [' ', '+', '-']; // 숫자 사이에 삽입할 문자 목록
let T = getInt(); // 테스트 케이스 수
let N; // 삽입해야할 문자 갯수
let S; // 지금까지 선택한 문자 목록
let 답 = []; // 출력할 답 목록
for (let t = 0; t < T; ++t) {
  N = getInt() - 1; // 삽입해야할 문자 갯수는 수의 갯수-1 이다
  S = []; // 지금까지 선택한 문자 목록
  DFS(0);
  답.push(''); // 테스트 케이스 출력 사이에 빈줄을 출력해야 한다
}
console.log(답.join('\n'));

function DFS(count) { // count: 지금까지 선택한 문자 갯수
  if (count == N) { // N개의 문자를 선택했다면,
     // 선택된 N개의 문자를, N+1개의 숫자 사이에 끼워넣은 표현식 문자열을 만든다
    let expr = createExpr();

    // 표현식 문자열에서 공백 문자들을 전부 제거한 표현식을
    // javascript eval 함수를 이용해서 실행한다.
    // eval 함수를 직접 구현한 소스코드는, java 답을 참고하라
    if (eval(expr.replaceAll(" ","")) == 0)
      답.push(expr); // 실행 결과가 0이면 그 표현식 문자열을 답 목록에 추가한다
    return;
  }
  for (let i = 0; i < 3; ++i) {
    S[count] = OP[i]; // OP[i] 문자를 선택하고
    DFS(count+1);  // 재귀호출
      // 선택한 갯수가 count 변수로 유지되기 때문에 S.pop() 할 필요 없다.
      //   재귀호출될 때 count 값이 count+1 되지만
      //   재귀호출에서 리턴하면 count 값은 재귀호출 전의 count 값 그대로이다
  }
}

// 선택된 N개의 문자를, N+1개의 숫자 사이에 끼워넣은 표현식 문자열을 만든다
function createExpr() {
  let list = ['1'];
  for (let i = 0; i < N; ++i) {
    list.push(S[i]);
    list.push(i+2);
  }
  return list.join('');
}