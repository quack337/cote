function solution(n, bans) {
  let B = [];
  for (let b of bans) {
    let i = b.length;
    if (!B[i]) B[i]=[];
    B[i].push(b);
  }
  console.log(B);
  var answer = '';
  return answer;
}

solution(30, ["d","e","bb","aa","ae"]);
solution(7388, ["gqk","kdn","jxj","jxi","fug","jxg","ewq","len","bhc"]);