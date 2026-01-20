// 시간 초과

function dfs(i, A, B) {
  if (A>=_A || B>=_B) return Infinity;
  if (i==_info.length) return A;
  let e = _info[i];
  return Math.min(dfs(i+1, A+e[0], B), dfs(i+1, A, B+e[1]));
}

function solution(info, A, B) {
  _info = info; _A=A; _B=B;
  x = dfs(0, 0, 0);
  return x==Infinity ? -1 : x;
}

console.log(solution([[1,1]], 4, 4) == 0);
console.log(solution([[1,2]], 4, 4) == 0);
console.log(solution([[1,3]], 4, 4) == 0);
console.log(solution([[1,4]], 4, 4) == 1);
console.log(solution([[2,4]], 4, 4) == 2);
console.log(solution([[3,4]], 4, 4) == 3);
console.log(solution([[4,4]], 4, 4) == -1);
console.log(solution([[1,2],[3,2]], 4, 4) == 1);
console.log(solution([[2,2],[3,2]], 4, 4) == 2);
console.log(solution([[1,2],[2,3],[2,1]], 4, 4) == 2);
console.log(solution([[1,2],[2,3],[2,1]], 1, 7) == 0);
console.log(solution([[3,3],[3,3]], 7, 1) == 6);
console.log(solution([[3,3],[3,3]], 6, 1) == -1);