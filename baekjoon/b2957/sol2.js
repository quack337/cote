function add(node, from, to, x) {
  node.count++;
  if (node.count == to - from + 1) {
    delete node.left; delete node.right;
    return;
  }
  let middle = Math.round((from + to) / 2);
  if (x < middle) {
    if (!node.left) node.left = { count: 0 };
    add(node.left, from, middle - 1, x);
  } else {
    if (!node.right) node.right = { count: 0 };
    add(node.right, middle, to, x);
  }
}

function findLP(node, from, to, x) {
  if (!node || node.count == 0 || x <= from) return -1;
  if (node.count == to - from + 1) return Math.min(x - 1, to);
  let middle = Math.round((from + to) / 2);
  let r = findLP(node.right, middle, to, x);
  if (r != -1) return r;
  return findLP(node.left, from, middle - 1, x);
}

function findRP(node, from, to, x) {
  if (!node || node.count == 0 || x >= to) return -1;
  if (node.count == to - from + 1) return Math.max(x + 1, from);
  let middle = Math.round((from + to) / 2);
  let r = findRP(node.left, from, middle - 1, x);
  if (r != -1) return r;
  return findRP(node.right, middle, to, x);
}

let seg_root = {count: 0}, map = [];
let N, count = 0;

function mapAdd(x, node) {
  map[x] = node;
  add(seg_root, 0, N, x);
}

function insert(x) {
  let parentNode = null;
  let lp = findLP(seg_root, 0, N, x);
  if (lp >= 0 && !(parentNode = map[lp]).right) {
    let node = {value: x, depth: parentNode.depth + 1};
    mapAdd(x, node);
    parentNode.right = node;
  } else {
    let rp = findRP(seg_root, 0, N, x);
    parentNode = map[rp];
    let node = {value: x, depth: parentNode.depth + 1};
    mapAdd(x, node);
    parentNode.left = node;
  }
  count += parentNode.depth;
}

const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');
const output = [];
N = parseInt(input[0]);
root = {value: parseInt(input[1]), depth: 1};
mapAdd(root.value, root);
output.push(0);
for (let i = 1; i < N; ++i) {
  let a = parseInt(input[1 + i]);
  insert(a);
  output.push(count);
}
console.log(output.join('\n'));
