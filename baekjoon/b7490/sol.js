let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => +data[idx++];
const OP = [' ', '+', '-'];
let T = getInt(), N, selected, result = []
for (let t = 0; t < T; ++t) {
  N = getInt() - 1;
  selected = [];
  DFS();
  result.push('');
}
console.log(result.join('\n'));

function DFS() {
  if (selected.length == N) {
    let expr = createExpr();
    if (eval(expr.replaceAll(" ","")) == 0)
      result.push(expr);
    return;
  }
  for (let i = 0; i < 3; ++i) {
    selected.push(i);
    DFS();
    selected.pop(i);
  }
}

function createExpr() {
  let list = ['1'];
  for (let i = 0; i < N; ++i) {
    list.push(OP[selected[i]]);
    list.push(String(i+2));
  }
  return list.join('');
}