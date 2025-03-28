function solution(citations) {
  citations.sort((a, b) => a - b);
  for (let h = citations.length; h > 0; --h)
    if (citations[citations.length - h] >= h)
      return h;
  return 0;
}

console.log(solution([3, 0, 6, 1, 5]));
console.log(solution([3, 3]));
console.log(solution([]));
