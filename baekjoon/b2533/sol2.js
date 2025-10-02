// 통과
let IN=(require('fs').readFileSync(0)+'').split('\n');
let N=+IN[0];
let M=[Array(N),Array(N)];
let links=Array(N).fill().map(_=>[]);
for (let i=1; i<N; ++i) {
  let S=IN[i].split(' '), a=S[0]-1, b=S[1]-1;
  links[a].push(b);
  links[b].push(a);
}
console.log(DFS(0, -1, 1));

function DFS(node, parent, psel) {
  if (M[psel][node] != undefined) return M[psel][node];
  let a = 0; // node를 선택 않는 경우
  let b = 1; // node를 선택하는 경우
  let children = links[node];
  for (let i=0; i < children.length; ++i) {
    let child = children[i];
    if (child == parent) continue;
    if (psel) a += DFS(child, node, 0);
    b += DFS(child, node, 1);
  }
  return M[psel][node] = psel ? Math.min(a, b) : b;
}