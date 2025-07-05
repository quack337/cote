let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => +data[idx++];
const OP = [' ', '+', '-'];
let T = getInt(), N, op, result = []
for (let t = 0; t < T; ++t) {
  N = getInt()-1;
  op = [];
  DFS();
  result.push('');
}
console.log(result.join('\n'));

function DFS() {
  if (op.length == N) {
    let exp = createExpr();
    if (eval(exp.replaceAll(" ","")) == 0)
      result.push(exp);
    return;
  }
  for (let i = 0; i < 3; ++i) {
    op.push(i);
    DFS();
    op.pop(i);
  }
}

function createExpr() {
  let list = ['1'];
  for (let i = 0; i < N; ++i) {
    list.push(OP[op[i]]);
    list.push(i+2);
  }
  return list.join('');
}