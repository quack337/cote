let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => parseInt(input[idx++]);
let N = getInt(), R = getInt(); // N개의 재료 중에서 R개를 선택해야 한다
let A = Array(N).fill().map(_=>[]); // N행 1열의 2차원 배열을 만든다
for (let r=0; r<N; ++r)
  for (let c=0; c<N; ++c)
    A[r][c] = getInt(); // 입력으로 주어진 2차원 배열
let S=[]; // 지금까지 선택한 재료 목록
let 답=-Infinity;
DFS(0,N-R,0);
console.log(답);

function DFS(from,to,count) { // count: 지금까지 선택한 재료 갯수
  if (count==R) { // R개를 선택했다면
    let 맛=0;
    for (let i=0; i<R-1; ++i) // nC2 조합 각각에 대해서 맛을 계산한다
      for (let j=i+1; j<R; ++j)
        맛 += A[S[i]][S[j]]
    if (맛>답) 답=맛; // 맛의 최대값을 찾는다
    return
  }
  for (let i=from; i<=to; ++i) {
    S[count] = i; // i 번째 재료를 선택하고
    DFS(i+1,to+1,count+1); // 재귀호출
            // 선택한 갯수가 count 변수로 유지되기 때문에 S.pop() 할 필요 없다.
            //   재귀호출될 때 count 값이 count+1 되지만
            //   재귀호출에서 리턴하면 count 값은 재귀호출 전의 count 값 그대로이다
  }
}