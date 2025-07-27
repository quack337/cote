// 오답: 반례 HKAHIKHEJW, MTHZEHCLSK
//  선두 일치 문자를 무시하는 경우가 최대값일 수도 있음
let [X,Y] = require('fs').readFileSync(0).toString().split('\n')
let M=Array(X.length).fill().map(_=>Array(Y.length))
console.log(BT(0,0))

function BT(i, j) {
  if (i==X.length || j==Y.length) return 0;
  if (M[i][j]) return M[i][j]
  let a=0, b=0, ii, jj;
  [ii, jj] = find1(X, i, Y, j);
  if (ii > -1) a = BT(ii+1, jj+1) + 1;
  [jj, ii] = find1(Y, j, X, i);
  if (jj > -1) b = BT(ii+1, jj+1) + 1;
  return M[i][j]=Math.max(a, b);
}

function find1(x, i, y, j) {
  let jj;
  while (i<x.length && (jj=find2(x[i], y, j)) < 0) ++i;
  return i<x.length ? [i, jj] : [-1, -1]
}

function find2(c, s, i) {
  for (; i<s.length; ++i)
    if (s[i]==c) return i
  return -1
}