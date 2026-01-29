function solution(n, bans) {
  let B = [];
  for (let b of bans) {
    let i = b.length;
    if (!B[i]) B[i]=[];
    B[i].push(b);
  }
  for (let 자릿수=1; ; ++자릿수) {
    let 갯수 = 26 ** 자릿수 - (B[자릿수]?B[자릿수].length:0);
    if (n <= 갯수) return 자릿수;
    else n -= 갯수;
  }
}

console.log(solution(30, ["d","e","bb","aa","ae"]));
console.log(solution(7388, ["gqk","kdn","jxj","jxi","fug","jxg","ewq","len","bhc"]));