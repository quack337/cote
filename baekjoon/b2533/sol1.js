// 메모리 초과 에러. 그렇지만 java의 경우는 통과.
// early adapter 적용할 때, transitive 관계는 고려하지 않음.
let IN=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let N=IN[0][0];
let M=[[],[]];
let links=Array(N).fill().map(_=>[]);
for (let i=1; i<N; ++i) {
  let [a,b]=IN[i]; --a; --b;
  links[a].push(b);
  links[b].push(a);
}
console.log(DFS(0, -1, 1));

function DFS(node, parent, parent_seleted) {
  if (M[parent_seleted][node] != undefined) return M[parent_seleted][node];
  let a = 0; // node를 선택 않는 경우
  let b = 1; // node를 선택하는 경우
  let children = links[node];
  for (let i=0; i < children.length; ++i) {
    let child = children[i];
    if (child == parent) continue;
    if (parent_seleted) a += DFS(child, node, 0);
    b += DFS(child, node, 1);
  }
  return M[parent_seleted][node] = parent_seleted ? Math.min(a, b) : b;
}