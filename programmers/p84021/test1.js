/*
1 2
3 4
5 6

5 3 1  (2,0) (1,0) (0,0)
6 4 2  (2,1) (1,1) (0,1)
*/
function rotate(a) {
  let A_ROW = a.length, A_COL = a[0].length;
  let b = Array(A_COL).fill().map(() => Array(A_ROW));
  for (let r = 0; r < b.length; ++r)
    for (let c = 0; c < b[0].length; ++c)
      b[r][c] = a[A_ROW-1-c][r];
  return b;
}

function print(a) {
  for (let r = 0; r < a.length; ++r)
    console.log(a[r]);
  console.log()
}

let a = [[1,2],[3,4],[5,6]];
  print(a);
for (let i = 0; i < 4; ++i) {
  a = rotate(a);
  print(a);
}
