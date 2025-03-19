function solution(p) {
  p.sort();
  for (let i = 1; i < p.length; ++i)
    if (p[i].length > p[i-1].length && p[i].startsWith(p[i-1]))
      return false;
  return true;
}

console.log(solution(["119", "97674223", "1195524421"]));
console.log(solution(["123", "456", "789"]));
console.log(solution(["12", "123", "1235", "567", "88"]));
