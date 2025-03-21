function countingSort(arr, start, end, nth) {
  const count = new Array(256).fill(0);
  for (let i = start; i <= end; ++i) {
    const value = arr[i];
    const digit = (value >> (nth * 8)) & 0xFF;
    ++count[digit];
  }
  const index = new Array(256).fill(0);
  for (let i = 1; i < index.length; ++i)
    index[i] = index[i - 1] + count[i - 1];
  const temp = new Array(end - start + 1);
  for (let i = start; i <= end; ++i) {
    const value = arr[i];
    const digit = (value >> (nth * 8)) & 0xFF;
    temp[index[digit]++] = value;
  }
  for (let i = start; i <= end; ++i)
    arr[i] = temp[i - start];
}

function swap(arr, i, j) {
  const temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

function partitionBy0(arr) {
  let i = -1;
  for (let j = 0; j < arr.length; ++j)
    if (arr[j] < 0)
      swap(arr, ++i, j);
  return i + 1;
}

function radixSort(arr) {
  const middle = partitionBy0(arr);
  for (let i = 0; i < 4; ++i) {
    countingSort(arr, 0, middle - 1, i);
    countingSort(arr, middle, arr.length - 1, i);
  }
}

function select(arr, k) {
  radixSort(arr);
  return arr[k - 1];
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let k = parseInt(input[index++]);
let arr = [];
for (let i = 0; i < N; ++i)
  arr[i] = parseInt(input[index++]);
console.log(select(arr, k));
