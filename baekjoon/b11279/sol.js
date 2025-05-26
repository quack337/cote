class MaxHeap {
  constructor() {
    this.heap = [];
  }

  insert(value) {
    this.heap.push(value);
    this.heapifyUp(this.heap.length - 1);
  }

  heapifyUp(index) {
    while (index > 0) {
      const parentIndex = (index - 1) >> 1;
      if (this.heap[parentIndex] >= this.heap[index]) break;
      [this.heap[parentIndex], this.heap[index]] = [this.heap[index], this.heap[parentIndex]];
      index = parentIndex;
    }
  }

  remove() {
    const min = this.heap[0];
    const end = this.heap.pop();
    if (this.heap.length > 0) {
      this.heap[0] = end;
      this.heapifyDown(0);
    }
    return min;
  }

  heapifyDown(index) {
    while (index < this.heap.length) {
      const left = (index << 1) + 1;
      const right = (index << 1) + 2;
      let largest = index;
      if (left < this.heap.length && this.heap[left] > this.heap[largest])
        largest = left;
      if (right < this.heap.length && this.heap[right] > this.heap[largest])
        largest = right;
      if (largest === index) break;
      [this.heap[index], this.heap[largest]] = [this.heap[largest], this.heap[index]];
      index = largest;
    }
  }

  size() {
    return this.heap.length;
  }
}

const fs = require('fs');
const input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
const N = parseInt(input[0]);
const heap = new MaxHeap();
const result = []
for (let i = 0; i < N; ++i) {
    let a = parseInt(input[i + 1]);
    if (a > 0) heap.insert(a);
    else
        result.push(heap.size() > 0 ? heap.remove() : 0);
}
console.log(result.join('\n'));
