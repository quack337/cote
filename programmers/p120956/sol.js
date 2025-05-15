function solution(babbling) {
  let answer = 0;
  for (let b of babbling) {
    for (let s of ["aya", "ye", "woo", "ma"])
      b = b.replace(s, " ");
    if (b.trim().length == 0) ++answer;
  }
  return answer;
}

console.log(solution(["aya", "yee", "u", "maa", "wyeoo"]));
console.log(solution(["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]));