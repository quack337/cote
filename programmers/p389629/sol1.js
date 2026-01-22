function dfs(r,c,e) {
  let x=1, g=G[r][c]; // -1 \  1 /
  if (V[r][c][e<0?0:1]) return 0; 
  if (V[r][c][e<0?1:0] == id) return 0;
  V[r][c][e<0?0:1]=id;
  if (e==-1 && r>0) x += dfs(r-1,c,1);
  if (e==1 && r<R-1) x += dfs(r+1,c,-1);
  if (e==g && c<C-1) x += dfs(r,c+1, G[r][c+1]*-1);
  if (e!=g && c>0) x += dfs(r,c-1, G[r][c-1]);
  return x;
}

function solution(grid) {
  G=grid; R=G.length; C=G[0].length;
  V=Array(R).fill().map(_=>Array(C).fill().map(_=>[]));
  let x=0;
  id=0;
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
//console.log(V.map(r => r.join(' ')).join('\n'));
