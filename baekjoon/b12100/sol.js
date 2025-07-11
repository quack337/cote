// 답
let IN = require('fs').readFileSync(0).toString().split('\n'),
  N=+IN[0].trim(), A=IN.slice(1).map(s=>s.split(' ').map(e=>+e));
let ANS=0, MV=[], merged;
DFS();
console.log(ANS);

function DFS() {
  let v = value();
  if (v > ANS) ANS = v;
  if (MV.length == 5) return;
  for (let dir=0; dir<4; ++dir) {
    MV.push(dir); DFS(); MV.pop();
  }
}

function value() {
  let v=0, B = A.map(e=>[...e]);
  for (let dir of MV) move(B,dir);
  for (let row of B)
    for (let c of row)
      if (c>v) v=c;
  return v;
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
