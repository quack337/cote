function solution(citations) {
  for (let h = citations.length; h > 0; --h) {
    let count = 0;
    for (let value of citations)
      if (value >= h)
        ++count;
    if (count >= h)
      return h;
  }
  return 0;
}

console.log(solution([3, 0, 6, 1, 5]));
console.log(solution([3, 3]));
console.log(solution([0]));
