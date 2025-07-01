function solution(list, r) {
  let result = [], selected = [], N = list.length;
  DFS();
  return result;

  function DFS() {
    if (selected.length == r) { // r개의 항목을 선택했으면
      let a = [];
      for (let i = 0; i < N; ++i)
        if (selected[i]) a.push(list[i]);
      result.push(a.join('')); // 선택한 조합을 result에 추가하고 리턴
      return;
    }
    for (let i = 0; i < N; ++i) // 주어진 알파벳 각각에 대해서 반복
      if (!selected[i]) { // i 위치의 알파벳을 아직 선택하지 않았다면
        selected[i] = true;  // 이 알파벳을 선택하고
        DFS();               // 재귀호출
        selected[i] = false; // 선택했던 것 취소
      }
  }
}

let result = solution(["A","B","C","D"], 3);
console.log(result.join(' '));
