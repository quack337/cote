class PriorityQueue {
  constructor(compare) {
    this.heap = [];
    this.compare = compare;
  }

  insert(value) {
    this.heap.push(value);
    this.heapifyUp(this.heap.length - 1);
  }

  heapifyUp(index) {
    while (index > 0) {
      const parentIndex = (index - 1) >> 1;
      if (this.compare(this.heap[parentIndex], this.heap[index]) <= 0) break;
      [this.heap[parentIndex], this.heap[index]] = [this.heap[index], this.heap[parentIndex]];
      index = parentIndex;
    }
  }

  peek() { return this.heap[0]; }

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
      let smallest = index;
      if (left < this.heap.length && this.compare(this.heap[left], this.heap[smallest]) < 0)
        smallest = left;
      if (right < this.heap.length && this.compare(this.heap[right], this.heap[smallest]) < 0)
        smallest = right;
      if (smallest === index) break;
      [this.heap[index], this.heap[smallest]] = [this.heap[smallest], this.heap[index]];
      index = smallest;
    }
  }

  size() {
    return this.heap.length;
  }
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let N = parseInt(input[0]);
let maxHeap = new PriorityQueue((a, b) => b - a);
let minHeap = new PriorityQueue((a, b) => a - b);
let zero = false;
for (let i = 0; i < N; ++i) {
    let value = parseInt(input[i + 1]);
    if (value > 0) maxHeap.insert(value);
    else if (value < 0) minHeap.insert(value);
    else zero = true;
}
let answer = 0;
while (maxHeap.size() >= 2) {
    let a = maxHeap.remove();
    let b = maxHeap.remove();
    answer += Math.max(a * b, a + b);
}
if (maxHeap.size() == 1)
    answer += maxHeap.remove();
while (minHeap.size() >= 2) {
    let a = minHeap.remove();
    let b = minHeap.remove();
    answer += a * b;
}
if (minHeap.size() == 1 && zero == false)
    answer += minHeap.remove();
console.log(answer);

