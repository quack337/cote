let IN = require('fs').readFileSync(0).toString().split('\n'),
A=IN.slice(1).map(s=>s.split(' ').map(e=>+e)), ANS=0, memo1=new Map(),
NN=0, EE=1, SS=2, WW=3;
DFS(0,A);
console.log(ANS);

function DFS(n, A) {
  if (n < 9) {
    let s = JSON.stringify(A);
    if (memo1.has(s)) {
      let nn = memo1.get(s);
      if (nn <= n) return;
    } else
      memo1.set(s, n);
  }
  let val = value(A);
  if (val > ANS) ANS = val;
  else if ((val << (10-n)) <= ANS) return;
  if (n == 10) return;
  if (!check(A)) return;
  DFS(n+1, move(A,NN));
  DFS(n+1, move(A,EE));
  DFS(n+1, move(A,SS));
  DFS(n+1, move(A,WW));
}

function value(A) {
  let max=0;
  for (let row of A)
    for (let val of row)
      if (val>max) max=val;
  return max;
}

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

function check(A) {
  let set = 0;
  for (let r=0; r<A.length; ++r)
    for (let c=0; c<A[0].length; ++c)
      if ((set & A[r][c]) != 0) return true;
      else set |= A[r][c];
  return false;
}