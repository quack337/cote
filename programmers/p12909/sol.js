function solution(s){
  let count = 0;
  for (let ch of s) {
    if (ch == '(') ++count;
    else if (ch == ')') --count;
    if (count < 0) return false;
  }
  return count == 0;
}

console.log(solution("()()"));
console.log(solution("(())()"));
console.log(solution(")()("));
console.log(solution("(()("));
