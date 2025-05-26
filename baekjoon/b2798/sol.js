let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let N = parseInt(input[0]);
let M = parseInt(input[1]);
let 카드 = [];
for (let i = 0; i < N; ++i)
   카드[i] = parseInt(input[i + 2]);

let 카드합계_최대값 = 0;
solution(0, 0, 0);
console.log(카드합계_최대값);

function solution(index, 선택한_카드수, 카드합계) {
  if (선택한_카드수 == 3) {
    if (카드합계 <= M && 카드합계 > 카드합계_최대값)
      카드합계_최대값 = 카드합계;
    return;
  }
  if (선택한_카드수 + 카드.length - index < 3) return;
  solution(index + 1, 선택한_카드수, 카드합계);
  solution(index + 1, 선택한_카드수 + 1, 카드합계 + 카드[index]);
}
