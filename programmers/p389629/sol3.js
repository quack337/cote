function dfs(r0,c0,e0) {
  let stack = [[r0,c0,e0]], x=0;
  while (stack.length) {
    let [r,c,e] = stack.pop();
    let g=G[r][c];
    if (V[r][c][e<0?0:1]==id || V[r][c][e<0?1:0]==id) continue;
    V[r][c][e<0?0:1]=id; ++x;
    if (e==-1 && r>0) stack.push([r-1,c,1]);
    if (e==1 && r<R-1) stack.push([r+1,c,-1]);
    if (e==g && c<C-1) stack.push([r,c+1, G[r][c+1]*-1]);
    if (e!=g && c>0) stack.push([r,c-1, G[r][c-1]]);
  }
  return x;
}

function solution(grid) {
  G=grid; R=G.length; C=G[0].length;
  let x=0;
  id=0;
  V=Array(R).fill().map(_=>Array(C).fill().map(_=>[]));
  for (let r=0;r<R;++r)
  for (let c=0;c<C;++c)
  for (let e=0;e<2;++e)
    if (!V[r][c][e]) {
      ++id;
      x = Math.max(x, dfs(r,c,e?1:-1));
    }
  return x;
}

console.log(solution([[-1,-1,-1],[1,1,-1],[1,1,1]]));
console.log(solution([[1,-1,1],[-1,1,-1]]));
console.log(solution([[1]]));
