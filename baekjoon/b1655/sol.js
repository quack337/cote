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
let result = [];
let A = new PriorityQueue((a, b) => b - a); // 최대힙
let B = new PriorityQueue((a, b) => a - b); // 최소힙
let N = parseInt(input[0]);
for (let i = 0; i < N; ++i) {
  let x = parseInt(input[i + 1]);
  if (A.size() == 0 || x <= A.peek()) A.insert(x);
    else B.insert(x);

    while (A.size() > B.size() + 1)
      B.insert(A.remove());

    while (B.size() > A.size())
       A.insert(B.remove());

    result.push(A.peek());
}
console.log(result.join('\n'));
