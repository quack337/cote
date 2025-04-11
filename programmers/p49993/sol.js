function 스킬순서찾기(skill) {
  const order = Array(26).fill(0);
  let no = 1;
  for (const ch of skill) {
    order[ch.charCodeAt(0) - 'A'.charCodeAt(0)] = no;
    no++;
  }
  return order;
}

function 가능한스킬트리인가(order, skillTree) {
  let no = 1;
  for (const ch of skillTree) {
    if (order[ch.charCodeAt(0) - 'A'.charCodeAt(0)] === 0) continue;
    if (order[ch.charCodeAt(0) - 'A'.charCodeAt(0)] !== no) return false;
    no++;
  }
  return true;
}

function solution(skill, skillTrees) {
  let answer = 0;
  const order = 스킬순서찾기(skill);
  for (const skillTree of skillTrees)
    if (가능한스킬트리인가(order, skillTree))
      answer++;
  return answer;
}

console.log(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]));
