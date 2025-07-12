// 이동 구현
// 이동 결과 배열은 모두 동쪽 이동 방형으로 회전되어 있다.
// 최대값만 중요하니까 배열 회전 여부는 어차피 상관없다.
let A=[[0,2,0,1],[0,0,2,0],[0,0,3,3],[0,4,0,4]];
let N=0, E=1, S=2, W=3;
print(A);
print(move(A, S));

A =  [[1,2,1,1],[4,2,0,2],[0,3,0,3],[4,0,0,4]];
print(A);
print(move(A, S));

function move(A, dir) {
  let B = [], size = 0, row1;
  if (dir==1 || dir==3) {
    for (let row of A) {
      if (dir==1) row1 = moveE(row);
      else if (dir==3) row1 = moveW(row);
      if (row1.length > size) size = row1.length;
      B.push(row1);
    }
  }
  else if (dir==0) {
    for (let c=0; c < A[0].length; ++c) {
      let row = [];
      for (let r=A.length-1; r >=0; --r)
        row.push(A[r][c]);
      row1 = moveE(row);
      if (row1.length > size) size = row1.length;
      B.push(row1);
    }
  }
  else if (dir==2) {
    for (let c=0; c < A[0].length; ++c) {
      let row = [];
      for (let r=0; r < A.length; ++r)
        row.push(A[r][c]);
      row1 = moveE(row);
      if (row1.length > size) size = row1.length;
      B.push(row1);
    }
  }
  resize(B, size);
  return B;
}

function resize(A, size) {
  for (let row of A)
    while (row.length < size)
      row.push(0);
}

function moveE(row) {
  let stack = [], prev=-1, merged = false;
  for (let c = row.length-1; c >=0; --c) {
    let e = row[c];
    if (e) {
      if (merged || e != prev) {
        stack.push(prev = e);
        merged = false; }
      else {
        stack[stack.length-1] = e*2;
        merged = true;
      }
    }
  }
  return stack;
}

function moveW(row) {
  let stack = [], prev=-1, merged = false;
  for (let c = 0; c < row.length; ++c) {
    let e = row[c];
    if (e) {
      if (merged || e != prev) {
        stack.push(prev = e);
        merged = false; }
      else {
        stack[stack.length-1] = e*2;
        merged = true;
      }
    }
  }
  return stack;
}

function print(A) {
  for (let r of A) console.log(r.map(e=>e==0?'.':''+e).join(' '));
  console.log();
}
