// nCr 25C7 = 480,700 확인
let selected = [], N = 25, R = 7, answer = 0;
DFS(0, N-R);
console.log(answer);

function DFS(from, to) {
  if (selected.length == R) {
    ++answer;
    return;
  }
  for (let i = from; i <= to; ++i)
    if (!selected.includes(i)) {
      selected.push(i);
      DFS(i + 1, to + 1);
      selected.pop();
    }
}