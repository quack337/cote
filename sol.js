let N = 4, R = 3;
let A = ['A', 'B', 'C', 'D'];
let selected = [];
DFS(0, N-R);

function DFS(from, to) {
  if (selected.length == R) {
    process.stdout.write(selected.join('') + ' ');
    return;
  }
  for (let i = from; i <= to; ++i) {
    selected.push(A[i]);
    DFS(i+1, to+1);
    selected.pop();
  }
}
