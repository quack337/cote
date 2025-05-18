function solution(word) {
  let list = ['A', 'E', 'I', 'O', 'U'];
  let dic = []
  for (let a of list) {
    dic.push(a);
    for (let b of list) {
      dic.push(a + b);
      for (let c of list) {
        dic.push(a + b + c);
        for (let d of list) {
          dic.push(a + b + c + d);
          for (let e of list)
            dic.push(a + b + c + d + e);
        }
      }
    }
  }
  return dic.indexOf(word) + 1;
}

console.log(solution("AAAAE"));
console.log(solution("AAAE"));
console.log(solution("I"));
console.log(solution("EIO"));
