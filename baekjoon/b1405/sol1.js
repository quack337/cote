// 시간 초과 4^14 = 268,435,456
let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getStr = () => data[idx++], getInt = () => +data[idx++];
let N = getInt(), A = [];
for (let i = 0; i < 4; ++i)
  A[i] = getInt() / 100;
const D = [[0,1],[0,-1],[1,0],[-1,0]];
let selected = [], 답 = 0;
DFS();
console.log(답);

function DFS() {
  if (selected.length == N) {
    let 확률 = selected.reduce((r,e) => r * A[e], 1);
    if (simple()) 답 += 확률;
    return;
  }
  for (let i = 0; i < 4; ++i) {
    selected.push(i);
    DFS();
    selected.pop();
  }
}

function simple() {
  let r = 0, c = 0, visited = new Set();
  visited.add(0);
  for (let i of selected) {
    r += D[i][0]; c += D[i][1];
    let val = r * N + c;
    if (visited.has(val)) return false;
    visited.add(val);
  }
  return true;
}
