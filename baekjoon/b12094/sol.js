let IN = require('fs').readFileSync(0).toString().split('\n'),
  N=+IN[0].trim(), A=IN.slice(1).map(s=>s.split(' ').map(e=>+e));
let ANS=0, merged;
DFS(0,A);
console.log(ANS);

function DFS(n, A) {
  let val = value(A);
  if (val > ANS) ANS = val;
  if (n == 10) return;
  for (let dir of getDir(A)) {
    let B = A.map(e=>[...e]);
    move(B, dir);
    DFS(n, B);
  }
}

function value(A) {
  let max=0;
  for (let row of A)
    for (let val of row)
      if (val>max) max=val;
  return max;
}

function move(A,dir) {
  merged = A.map(_=>[]);
  for (let r=0; r<N; ++r)
    for (let c=N-2; c>=0; --c)
      if (get(A,r,c,dir)>0) move2(A,r,c,dir);
}

function move2(A,r,c,dir) {
  let c1 = c+1;
  while (c1 < N-1 && get(A,r,c1,dir)==0)
    ++c1;
  if (get(A,r,c1,dir)==get(A,r,c,dir)) {
    if (!merged[r][c1]) {
      set(A,r,c1,dir, get(A,r,c1,dir)*2); merged[r][c1]=1; set(A,r,c,dir, 0);
      return;
    } else --c1;
  }
  else if (get(A,r,c1,dir) > 0) --c1;
  if (c != c1) {
    set(A,r,c1,dir, get(A,r,c,dir));
    set(A,r,c,dir, 0);
  }
}

function rotate(r,c,dir) { // N=0, E=1, S=2, W=3
  return dir==0 ? [N-1-c,r] : (dir==1 ? [r,c] : (dir==2 ? [c,r] : [r,N-1-c]));
}

function get(A,r,c,dir) {
  [r,c] = rotate(r,c,dir);
  return A[r][c];
}

function set(A,r,c,dir,x) {
  [r,c] = rotate(r,c,dir);
  A[r][c] = x;
}

function getDir(A) {
  let dir=[];
  label1:
  for (let r=0; r<N; ++r) {
    let pre = -1;
    for (let c=0; c<N; ++c)
      if (A[r][c]) {
        if (A[r][c]==pre) { dir=[1,3]; break label1; }
        pre=A[r][c];
      }
  }
  label2:
  for (let c=0; c<N; ++c) {
    let pre = -1;
    for (let r=0; r<N; ++r)
      if (A[r][c]) {
        if (A[r][c]==pre) { dir=[...dir,0,2]; break label2; }
        pre=A[r][c];
      }
  }
  return dir;
}
