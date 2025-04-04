function solution(arrows) {
  let 좌표계산 = [[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1],[-1,-1]];
  let 선_목록 = new Set();
  let 선_계산 = [[1,0,0],[1,-1,1],[0,-1,2],[0,-1,3],[0,0,0],[0,0,1],[0,0,2],[1,0,3]];
  let 방문_목록 = new Set(["0,0"]);
  let 행 = 0, 열 = 0, 답 = 0;
  for (let arrow of arrows) {
    for (let i = 0; i < 2; ++i) {
      행 += 좌표계산[arrow][0];
      열 += 좌표계산[arrow][1];
      let 선_행 = 행 + 선_계산[arrow][0];
      let 선_열 = 열 + 선_계산[arrow][1];
      let 선_방향 = 선_계산[arrow][2];
      let 선_키 = 선_행 + "," + 선_열 + "," + 선_방향;
      let 좌표_키 = 행 + "," + 열;
      if (방문_목록.has(좌표_키) && !선_목록.has(선_키)) {
        //console.log(arrow, 좌표_키, 선_키, 방문_목록, 선_목록);
        ++답;
      }
      방문_목록.add(좌표_키);
      선_목록.add(선_키);
    }
  }
  return 답;
}

console.log(solution([6,6,6,4,4,4,2,2,2,0,0,0,1,6,5,5,3,6,0])); // 3
console.log(solution([0,4])); // 0
console.log(solution([0,2,4,6,0,2,4,6])); // 1
console.log(solution([0,2,4,6,1,4,7])); // 4
console.log(solution([0,2,4,6,1,4,7,1,4])); // 5
console.log(solution([0,2,4,6,1,4,7,1,4,6])); // 5

