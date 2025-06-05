const INF = 999999999;
let DP = [];

function 완전탐색(n) {
  if (DP[n]) return DP[n];
  if (n == 5 || n == 3) return DP[n] = 1;
  let r1 = INF, r2 = INF;
  if (n > 5) r1 = 완전탐색(n - 5) + 1;
  if (n > 3) r2 = 완전탐색(n - 3) + 1;
  return DP[n] = (r1 < r2 ? r1 : r2);
}

function solution(n) {
  let r = 완전탐색(n);
  return r >= INF ? -1 : r;
}

let A = [[1,-1],[2,-1],[3,1],[4,-1],[5,1],[6,2],[7,-1],
  [8,2],[9,3],[10,2],[11,3],[12,4],[13,3],[14,4],[15,3],
  [16,4],[17,5],[18,4],[19,5],[20,4],[21,5],[22,6],[23,5]];

 for (let a of A)
   console.log(solution(a[0]) == a[1], a[0], solution(a[0]), a[1]); 
