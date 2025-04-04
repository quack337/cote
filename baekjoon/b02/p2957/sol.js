let root, map = {}, count = 0;

function insert(x) {
  let keys = Object.keys(map);
  let [found, index] = binarySearch(keys, x);
  let a = keys[index - 1];
  let parentNode = null;
  if (a >= 0 && (parentNode = map[a]).right == undefined) {
    let node = {value: x, depth: parentNode.depth + 1};
    map[x] = node;
    parentNode.right = node;
  } else {
    let b = keys[index];
    parentNode = map[b];
    let node = {value: x, depth: parentNode.depth + 1};
    map[x] = node;
    parentNode.left = node;
  }
  count += parentNode.depth;
}

function binarySearch(a, value) {
  let start = 0;
  let end = a.length - 1;
  while (start <= end) {
      let middle = (end + start) >> 1;
      if (value > a[middle])
          start = middle + 1;
      else if (value < a[middle])
          end = middle - 1;
      else
          return [true, middle];
  }
  return [false, start];
}

const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');
const N = parseInt(input[0]);
root = {value: parseInt(input[1]), depth: 1};
map[root.value] = root;
console.log(0);
for (let i = 1; i < N; ++i) {
  let a = parseInt(input[1 + i]);
  insert(a);
  console.log(count);
}

// 메모리 초과
