function add(node, from, to, x) {
  node.count++;
  if (node.count == to - from + 1) {
    delete node.left; delete node.right;
    return;
  }
  let middle = Math.max(from + 1, Math.floor((from + to) / 2));
  if (x < middle) {
    if (!node.left) node.left = { from, to: middle - 1, count: 0 };
    add(node.left, from, middle - 1, x);
  } else {
    if (!node.right) node.right = { from: middle, to, count: 0 };
    add(node.right, middle, to, x);
  }
}

function findLP(node, from, to, x) {
  if (!node || node.count == 0 || x <= from) return -999;
  if (node.count == to - from + 1) return Math.min(x - 1, to);
  let middle = Math.max(from + 1, Math.floor((from + to) / 2));
  let r1 = findLP(node.left, from, middle - 1, x);
  let r2 = findLP(node.right, middle, to, x);
  return Math.max(r1, r2);
}

function findRP(node, from, to, x) {
  if (!node || node.count == 0 || x >= to) return 999_999_999;
  if (node.count == to - from + 1) return Math.max(x + 1, from);
  let middle = Math.max(from + 1, Math.floor((from + to) / 2));
  let r1 = findRP(node.left, from, middle - 1, x);
  let r2 = findRP(node.right, middle, to, x);
  return Math.min(r1, r2);
}

let A = [];
function findLP2(x) {
  let r = -999;
  for (let v of A)
    if (v < x) r = Math.max(r, v);
  return r;
}
function findRP2(x) {
  let r = 999_999_999;
  for (let v of A)
    if (v > x) r = Math.min(r, v);
  return r;
}
function add2(x) { A.push(x); }

let N = 200;
let values = [];
for (let i = 0; i < N; ++i)
  values[i] = i + 1;
for (let i = 1; i <= N; ++i) {
  let a = Math.floor(Math.random() * N);
  let b = Math.floor(Math.random() * N);
  [values[a], values[b]] = [values[b], values[a]];
}

let root = {count: 0};
for (let i = 0; i < N; ++i) {
  let x = values[i];
  add(root, 0, N, x);
  add2(x);
  //console.log(JSON.stringify(root));
  for (let j = 0; j <= N + 1; ++j) {
    let s1 = findLP(root, 0, N, j);
    let s2 = findLP2(j);
    if (s1 != s2) { console.log(s1, s2, A, j); return; }
    s1 = findRP(root, 0, N, j);
    s2 = findRP2(j);
    if (s1 != s2) { console.log(s1, s2, A, j); return; }
  }
}
