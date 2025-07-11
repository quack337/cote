let IN = require('fs').readFileSync(0).toString().split('\n'),
  A=IN.slice(1).map(s=>s.split(' ').map(e=>+e)), ANS=0;

DFS(0,A);
console.log(ANS);

function print(A) {
  for (let row of A) console.log(row.join(' '));
  console.log();
}

function DFS(n, A) {
  //print(A);
  let val = value(A);
  if (val > ANS) {
    ANS = val;
    print(A);
  }
  if (n == 10) return;
  if (checkH(A)) {
    let B;
    B = copy(A); moveE(B); DFS(n+1, B);
    B = copy(A); moveW(B); DFS(n+1, B);
  }
  if (checkV(A)) {
    let B;
    B = copy(A); moveN(B); DFS(n+1, B);
    B = copy(A); moveS(B); DFS(n+1, B);
  }
}

function value(A) {
  let max=0;
  for (let row of A)
    for (let val of row)
      if (val>max) max=val;
  return max;
}

function moveN(A) {
  for (let c=0; c<A[0].length; ++c) {
    let merged = [];
    for (let r=1; r<A.length; ++r)
      if (A[r][c]>0) moveN2(A,r,c,merged);
  }
}

function moveN2(A,r,c,merged) {
  let r1 = r-1;
  while (r1 > 0 && A[r1][c]==0)
    --r1;
  if (A[r1][c]==A[r][c]) {
    if (!merged[r1]) {
      A[r1][c] *= 2; merged[r1]=true; A[r][c]=0;
      return;
    } else ++r1;
  }
  else if (A[r1][c] > 0) ++r1;
  if (r != r1) {
    A[r1][c] = A[r][c];
    A[r][c] = 0;
  }
}

function moveW(A) {
  for (let r=0; r<A.length; ++r) {
    let merged = [];
    for (let c=1; c<A[0].length; ++c)
      if (A[r][c]>0) moveW2(A,r,c,merged);
  }
}

function moveW2(A,r,c,merged) {
  let c1 = c-1;
  while (c1 > 0 && A[r][c1]==0)
    --c1;
  if (A[r][c1]==A[r][c]) {
    if (!merged[c1]) {
      A[r][c1] *= 2; merged[c1]=true; A[r][c]=0;
      return;
    } else ++c1;
  }
  else if (A[r][c1] > 0) ++c1;
  if (c != c1) {
    A[r][c1] = A[r][c];
    A[r][c] = 0;
  }
}

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

function checkH(A) {
  for (let r=0; r<A.length; ++r) {
    let pre = -1;
    for (let c=0; c<A[0].length; ++c)
      if (A[r][c]) {
        if (A[r][c]==pre) return true;
        pre=A[r][c];
      }
  }
  return false;
}

function checkV(A) {
  for (let c=0; c<A[0].length; ++c) {
    let pre = -1;
    for (let r=0; r<A.length; ++r)
      if (A[r][c]) {
        if (A[r][c]==pre) return true;
        pre=A[r][c];
      }
  }
  return false;
}

function copy(A) {
  let r1,r2,c1,c2;
  lb1:
  for (r1=0; r1<A.length; ++r1)
    for (let c=0; c < A[0].length; ++c)
      if (A[r1][c]) break lb1;
  lb2:
  for (r2=A.length-1; r2>0; --r2)
    for (let c=0; c < A[0].length; ++c)
      if (A[r2][c]) break lb2;
  lb3:
  for (c1=0; c1<A[0].length; ++c1)
    for (let r=0; r < A.length; ++r)
      if (A[r][c1]) break lb3;
  lb4:
  for (c2=A[0].length-1; c2>0; --c2)
    for (let r=0; r < A.length; ++r)
      if (A[r][c2]) break lb4;
  let B=Array(r2-r1+1).fill().map(_=>Array(c2-c1+1));
  for (let r=r1; r<=r2; ++r)
    for (let c=c1; c<=c2; ++c)
      B[r-r1][c-c1] = A[r][c];
  //console.log(r1, r2, c1, c2);
  return B;
}