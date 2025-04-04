function solution(progress, speed) {
  let answer = [];
  let 배포일 = Math.ceil((100 - progress[0]) / speed[0]);
  let 배포작업수 = 1;

  for (let i = 1; i < progress.length; i++) {
    let 마감일 = Math.ceil((100 - progress[i]) / speed[i]);
    if (마감일 <= 배포일) 배포작업수++;
    else {
      answer.push(배포작업수);
      배포일 = 마감일;
      배포작업수 = 1;
    }
  }
  answer.push(배포작업수);
  return answer;
}

const progress = [[93, 30, 55], [95, 90, 99, 99, 80, 99]];
const speed = [[1, 30, 5], [1, 1, 1, 1, 1, 1]];
for (let i = 0; i < progress.length; i++)
  console.log(solution(progress[i], speed[i]));
