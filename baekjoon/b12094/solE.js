// 이동 구현
let A=[[0,0,0,1],[0,0,2,0],[0,0,3,3],[0,4,0,4]];
print(A);
moveE(A);
print(A);

A =  [[2,0,1,1],[4,2,0,2],[0,3,0,3],[4,0,0,4]];
print(A);
moveE(A);
print(A);

function moveE(A) {
  for (let r=0; r<A.length; ++r) {
    let merged = [];
    for (let c=A[0].length-2; c>=0; --c)
      if (A[r][c]>0) moveE2(A,r,c,merged);
  }
}

function moveE2(A,r,c,merged) {
  let c1 = c+1;
  while (c1 < A[0].length-1 && A[r][c1]==0)
    ++c1;
  if (A[r][c1]==A[r][c]) {
    if (!merged[c1]) {
      A[r][c1] *= 2; merged[c1]=true; A[r][c]=0;
      return;
    } else --c1;
  }
  else if (A[r][c1] > 0) --c1;
  if (c != c1) {
    A[r][c1] = A[r][c];
    A[r][c] = 0;
  }
}


function print(A) {
  for (let r of A) console.log(r.map(e=>e==0?'.':''+e).join(' '));
  console.log();
}

