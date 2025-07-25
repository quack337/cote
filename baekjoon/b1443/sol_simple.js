let [D,N] = require('fs').readFileSync(0).toString().split(' ').map(e=>parseInt(e));
  // D 입력으로 주어진 계산기 자릿수
  // N 입력으로 주어진 곱셈 연산의 수
let MAX = Math.pow(10,D) // 초과 컷을 구현하기 위한 값
  // 예를 들어 D=2 이라면, 답은 99 이하이어야 한다. 즉 100 이상이면 초과컷 해야 한다

let 답 = -1; // 최대값을 구해야 하므로 -1로 초기화한다.
DFS(2,1,0); // 2: 2부터 9까지 선택 가능하다
            // 1: 지금까지 선택한 수들을 곱한 결과의 초기값
            // 0: 지금까지 선택한 수들의 갯수
console.log(답);

function DFS(from, x, count) { // x: 지금까지 선택한 수들을 곱합 결과
                               // count: 지금까지 선택한 갯수
  if (x >= MAX) return; // 초과 컷
  if(count==N) {   // N개를 선택했다면
    if(x>답) 답=x;  // 최대값을 찾는다
    return;
  }
  for (let i=from; i <= 9; ++i)
    DFS(i, x*i, count+1);
}
