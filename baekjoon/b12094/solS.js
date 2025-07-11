// 이동 구현
let A=[
[1,0,3,4],
[0,2,3,0],
[0,0,3,4],
[0,0,0,0]];
print(A);
moveS(A);
print(A);

A = [
[1,2,3,4],
[1,2,0,0],
[2,4,3,2],
[0,0,0,2]];
print(A);
moveS(A);
print(A);

function moveS(A) {
  for (let c=0; c<A[0].length; ++c) {
    let merged = [];
    for (let r=A.length-2; r>=0; --r)
      if (A[r][c]>0) moveS2(A,r,c,merged);
  }
}

function moveS2(A,r,c,merged) {
  let r1 = r+1;
  while (r1 < A.length-1 && A[r1][c]==0)
    ++r1;
  if (A[r1][c]==A[r][c]) {
    if (!merged[r1]) {
      A[r1][c] *= 2; merged[r1]=true; A[r][c]=0;
      return;
    } else --r1;
  }
  else if (A[r1][c] > 0) --r1;
  if (r != r1) {
    A[r1][c] = A[r][c];
    A[r][c] = 0;
  }
}


function print(A) {
  for (let r of A) console.log(r.map(e=>e==0?'.':''+e).join(' '));
  console.log();
}

