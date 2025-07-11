// 이동 구현
let merged = Array(4).fill().map(_=>[0,0,0,0]);
let N=4, A=[[0,0,0,1],[0,0,2,0],[0,0,3,3],[0,4,0,4]];
print(A);
move(A);
print(A);
console.log(merged)

A =  [[2,0,1,1],[4,2,0,2],[0,3,0,3],[4,0,0,4]];
print(A);
move(A);
print(A);
console.log(merged)

function move(A) {
  for (let r=0; r<N; ++r)
    for (let c=N-2; c>=0; --c)
      if (A[r][c]>0) move2(A,r,c);
}

function move2(A, r, c) {
  let c1 = c+1;
  while (c1 < N-1 && A[r][c1]==0)
    ++c1;
  if (A[r][c1]==A[r][c]) {
    if (!merged[r][c1]) {
      A[r][c1] *= 2; merged[r][c1]=1; A[r][c]=0;
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

