/*

2차원 배열 회전 함수

2차원 배열 비교 함수


각각의 칸에 대해서
  if 1이면, 
    DFS 탐색으로 r1, c1, r2, c2 좌표를 구한다.
    visited 표시
    이차원 배열을 기록한다.
*/


function equals(a, b) {
  if (a.length != b.length) return false;
  if (a[0].length != b[0].length) return false;
  for (let r = 0; r < a.length; ++r)
    for (let c = 0; c < a[0].length; ++c)
      if (a[r][c] != b[r][c]) return false;
  return true;
}

