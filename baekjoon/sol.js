let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getStr = () => data[idx++], getInt = () => +data[idx++];
let N = getInt();
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = getStr().split('');

let ROW = getInt(), COL = getInt();
let A = Array(ROW).fill().map(() => []);
for (let r = 0; r < ROW; ++r)
  for (let c = 0; c < COL; ++c)
    A[r][c] = getInt();
let visited = Array(ROW).fill().map(() => []);

let ROW = getInt();
let A = [];
for (let r = 0; r < ROW; ++r)
  A[r] = getStr().split('');
let visited = Array(ROW).fill().map(() => []);

let N = getInt(), E = getInt();
let neighbors = Array(N).fill().map(() => []);
for (let i = 0; i < E; ++i) {
  let a = getInt() - 1, b = getInt() - 1;
  neighbors[a].push(b);
  neighbors[b].push(a);
}
let visited = [];

let N = getInt(), E = getInt();
let neighbors = Array(N).fill().map(() => []);
for (let i = 0; i < E; ++i) {
  let a = getInt() - 1, b = getInt() - 1, cout = getInt();
  neighbors[a].push([b, cost]);
  neighbors[b].push([a, cost]);
}
let visited = [];


