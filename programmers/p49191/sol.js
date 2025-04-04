function DFS(index, links, visited) {
  if (visited.has(index)) return 0;
  visited.add(index);
  for (let child of links[index])
    DFS(child, links, visited);
}

function solution(n, results) {
  let children = Array(n).fill().map(() => []);
  let parents = Array(n).fill().map(() => []);
  for (let r of results) {
    let a = r[0] - 1, b = r[1] - 1;
    children[a].push(b);
    parents[b].push(a);
  };
  let answer = 0;
  for (let i = 0; i < n; ++i) {
    let visited1 = new Set(), visited2 = new Set();
    DFS(i, children, visited1);
    DFS(i, parents, visited2);
    if (visited1.size + visited2.size == n + 1)
      ++answer;
  }
  return answer;
}

console.log(solution(5, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]));
