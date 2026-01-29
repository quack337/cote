S = "abcdefghijklmnopqrstuvwxyz";

function sol(n, 자릿수, bans) {
  if (!자릿수) return "";
  let 갯수 = 26 ** (자릿수-1);
  let B = Array(26).fill().map(_=>[]);
  for (let b of bans) {
    let i = b[0].charCodeAt(0) - 'a'.charCodeAt(0);
    B[i].push(b.slice(1));
  }
  for (let i=0; i<26; ++i) {
    if (n <= 갯수-B[i].length)
      return S[i]+sol(n, 자릿수-1, B[i]);
    n -= 갯수-B[i].length;
  }
}

function solution(n, bans) {
  let B = [];
  for (let b of bans) {
    let i = b.length;
    if (!B[i]) B[i]=[];
    B[i].push(b);
  }
  for (let 자릿수=1; ; ++자릿수) {
    let 갯수 = 26 ** 자릿수 - (B[자릿수]?B[자릿수].length:0);
    if (n <= 갯수) return sol(n, 자릿수, B[자릿수]); 
    else n -= 갯수;
  }
}

console.log(solution(30, ["d","e","bb","aa","ae"]));
console.log(solution(7388, ["gqk","kdn","jxj","jxi","fug","jxg","ewq","len","bhc"]));