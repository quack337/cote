function solution(n, bans) {
  bans.sort((a, b) => a.length != b.length ?
    a.length - b.length : a.localeCompare(b));
  console.log(bans);
}

console.log(solution(30, ["d","e","bb","aa","ae"]));
console.log(solution(7388, 	["gqk","kdn","jxj","jxi","fug","jxg","ewq","len","bhc"]));
