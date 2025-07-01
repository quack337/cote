let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let S;
while (true) {
  let K = parseInt(input[index++]);
  if (K == 0) break;
  S = []
  for (let i = 0; i < K; ++i)
    S[i] = parseInt(input[index++]);
  DFS(0, []);
  console.log();
}

function DFS(index, selected) {
  if (selected.length == 6) {
    console.log(selected.join(' '));
    return;
  }
  if (selected.length + S.length - index < 6) return;
  selected.push(S[index]);
  DFS(index + 1, selected);
  selected.pop();
  DFS(index + 1, selected);
}
