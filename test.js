function DFS(list, selected, r, result) {
  if (selected.length == r) {
    result.push(selected.join(''));
    return;
  }
  for (let ch of list) {
    selected.push(ch);
    DFS(list, selected, r, result);
    selected.pop();
  }
}

function solution(list, r) {
  let result = [];
  DFS(list, [], r, result);
  return result;
}

let result = solution(['A', 'B', 'C', 'D'], 3);
console.log(result.join(' '));
