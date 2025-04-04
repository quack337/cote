function solution(brown, yellow) {
  for (let height = 1 ; height <= Math.sqrt(yellow); ++height) {
    if (yellow % height != 0) continue;
    let width = yellow / height;
    if (2 * width + 2 * height + 4 == brown)
      return [width + 2, height + 2];
  }
}

console.log(solution(10, 2));
console.log(solution(8, 1));
console.log(solution(24, 24));
