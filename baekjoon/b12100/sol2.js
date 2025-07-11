// 4방향 이동 구현
let N=4, merged, A1=[
 [[1,0,3,4],[0,2,3,0],[0,0,0,4],[0,0,0,0]],
 [[0,0,0,1],[0,0,2,0],[0,0,3,3],[0,4,0,4]],
 [[0,0,0,0],[0,0,0,4],[0,2,3,0],[1,0,3,4]],
 [[1,0,0,0],[0,2,0,0],[3,3,0,0],[4,0,4,0]]],
A2=[
 [[1,2,3,4],[1,0,3,0],[0,2,0,0],[2,4,0,4]],
 [[2,0,1,1],[4,2,0,2],[0,3,0,3],[4,0,0,4]],
 [[2,4,0,4],[0,2,0,0],[1,0,3,0],[1,2,3,4]],
 [[1,1,0,2],[2,0,2,4],[3,0,3,0],[4,0,0,4]]];

for (let dir=0; dir<N; ++dir) {
  merged = Array(N).fill().map(_=>[0,0,0,0]);
  let A = A1[dir].map(e=>[...e]);
  move(A,dir); print(A1[dir], A);
  console.log(merged)

  A = A2[dir].map(e=>[...e]);
  move(A,dir); print(A2[dir], A);
  console.log(merged)
}

function move(A,dir) {
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

function print(A, B) {
  for (let r=0; r<N; ++r)
    console.log(A[r].map(e=>e==0?'.':''+e).join(' ') + '     ' +
                B[r].map(e=>e==0?'.':''+e).join(' '));
  console.log();
}
