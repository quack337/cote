let N = parseInt(require('fs').readFileSync(0).toString().trim());
let memo=[];
// N 보다 작은 5의 배수들을 내림차순 순서로 반복
for (let i = Math.floor(N/5); i >= 0; --i) {
  let a = N - i * 5; // N에서 5의 배수를 빼고 남은 a
  if (a % 3 == 0) {  // a가 3의 배수이면, N는 5의 배수 + 3의 배수이다.
    console.log(i + a / 3); // 답 출력
    return;
  }
}
console.log(-1);
