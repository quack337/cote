let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => parseInt(input[idx++]);
let N = getInt(), R = N;
let V = []; // i 값을 선택했는지 표시하기 위한 배열. 중복 선택을 막기 위함.
let answer = []; // 출력할 답
DFS(0, '');
console.log(answer.join('\n'));

function DFS(n, s) { // n: 지금까지 선택한 갯수, s: 지금까지 선택한 수들을 연결한 문자열
  if (n==R) { // R개를 선택했다면
    // 선택한 수 목록을 문자열로 만들어서 answer 배열에 추가한다
    answer.push(s.trim());
    return;
  }
  for (let i = 1; i <= N; ++i)
    if (!V[i]) { // i를 아직 선택하지 않았다면
      V[i] = true; // i를 선택했다고 표시
      DFS(n+1, s+' '+i); // 재귀호출
      V[i] = false; // 재귀호출에서 리턴하자 마자 i 선택을 취소한다
    }
}