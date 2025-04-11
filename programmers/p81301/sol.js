function solution(s) {
  const a = ["zero", "one", "two", "three", "four", "five",
    "six", "seven", "eight", "nine"];
  for (let i = 0; i < a.length; i++)
    s = s.replaceAll(a[i], String(i));
  return parseInt(s);
}

console.log(solution("one4seveneight"));
console.log(solution("23four5six7"));
console.log(solution("2three45sixseven"));
console.log(solution("123"));
