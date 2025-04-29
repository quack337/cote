function solution(n, linked) {
  let answer = 0, visited = [];
  for (let a = 0; a < n; ++a)
    if (!visited[a]) {
      answer++;
      DFS(a);
    }
  return answer;

  function DFS(a) {
    visited[a] = true;
    for (let b = 0; b < n; ++b)
      if (linked[a][b] == 1 && !visited[b])
        DFS(b);
  }  
}



console.log(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]])); // 2
console.log(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]])); // 1