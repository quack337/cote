const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');
//const N = Number(input[0]);
const heights = input[1].split(' ').map(Number);
const stack = []; // 왼쪽 탑 목록
const result = [];
for (let i = 0; i < heights.length; i++) {
  let height = heights[i];
  let no = 0; // 신호를 수신할 탑 번호
  while (stack.length > 0) {
    if (stack[stack.length - 1].height >= height) { // 신호를 수신할 탑 발견
      no = stack[stack.length - 1].no;
      break;
    }
    stack.pop(); // 현재 탑보다 작거나 같은 탑들은 목록에서 제거
  }
  result.push(no); // 수신 탑 번호 저장
  while (stack.length > 0 && stack[stack.length - 1].height == height)
      stack.pop();  // 높이가 같은 탑들도 제거
  stack.push({ no: i + 1, height }); // 현재 탑을 목록에 추가
}
console.log(result.join(' '));
