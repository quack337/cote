let R = parseInt(require('fs').readFileSync(0).toString().trim())
let A = [1,5,10,50]; // 1,5,10,50의 조합으로 로마 숫자를 만든다
let set = new Set(); // 로마숫자를 조합해서 만들어진 수의 집합. 중복된 값이 자동으로 걸러진다
DFS(0,0,0);
console.log(set.size); // 답 출력

function DFS(from, sum, count) { // sum: 지금까지 선택한 수들의 합계, count: 지금까지 선택한 갯수
  if (count==R) set.add(sum); // R개를 선택했다면, 선택한 수들의 합계를 set에 추가하고 리턴한다
  else
    for (let i=from; i<A.length; ++i) // 아직 R개를 선택하지 않았다면
      DFS(i, sum+A[i], count+1); // A[i] 수를 선택하고 재귀호출
}