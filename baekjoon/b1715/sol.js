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
let minHeap = new PriorityQueue((a, b) => a - b); // 최소힙
let N = parseInt(input[0]);
for (let i = 0; i < N; ++i)
    minHeap.insert(parseInt(input[i + 1]));
let answer = 0;
while (minHeap.size() > 1) {
    let a = minHeap.remove();
    let b = minHeap.remove();
    let c = a + b;
    answer += c;
    minHeap.insert(c);
}
console.log(answer);
