function solution(brown, yellow) {
  let area = brown + yellow;
  for(let width = Math.floor(area / 3); width > 0; --width) {
      if(area % width != 0)
          continue;
      let height = area / width;
      
      if ((width-2)*(height-2) == yellow)
          return [width, height];
  }
}

console.log(solution(10, 2));
console.log(solution(8, 1));
console.log(solution(24, 24));
