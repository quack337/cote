function heapify(arr, end, i) {
  let left = 2 * i + 1, right = 2 * i + 2;
  let smaller;
  if (right <= end)
    smaller = arr[left] < arr[right] ? left : right;
  else if (left <= end)
    smaller = left;
  else
    return;
  if (arr[i] > arr[smaller]) {
    [arr[i], arr[smaller]] = [arr[smaller], arr[i]];
    heapify(arr, end, smaller);
  }
}

function buildHeap(arr) {
  for (let i = Math.floor(arr.length / 2); i >= 0; i--)
    heapify(arr, arr.length - 1, i);
}

function heapSort(arr) {
  buildHeap(arr);
  for (let i = arr.length - 1; i > 0; i--) {
    [arr[0], arr[i]] = [arr[i], arr[0]];
    heapify(arr, i - 1, 0);
  }
}

let a = [1, 2, 11, 12, 3, 42, 43, 13, 21, 41, 44, 33, 22, 23, 31, 32];
heapSort(a);
console.log(a);