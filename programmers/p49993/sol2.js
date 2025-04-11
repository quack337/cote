function solution(skill, skillTrees) {
  let regex = new RegExp("[^" + skill + "]", "g");
  let a = skillTrees.filter(skillTree => skill.startsWith(skillTree.replaceAll(regex, "")));
  return a.length;
}

console.log(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]));
