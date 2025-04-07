class PriorityQueue {
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
      if (this.heap[parentIndex].priority <= this.heap[index].priority) break;
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
      let smallest = index;
      if (this.heap[left] && this.heap[left].priority < this.heap[smallest].priority) {
        smallest = left;
      }
      if (this.heap[right] && this.heap[right].priority < this.heap[smallest].priority) {
        smallest = right;
      }
      if (smallest === index) break;
      [this.heap[index], this.heap[smallest]] = [this.heap[smallest], this.heap[index]];
      index = smallest;
    }
  }

  isEmpty() {
    return this.heap.length === 0;
  }
}

let queue = new PriorityQueue();
for (let i = 0; i < 50; i++) {
  const randomValue = Math.floor(Math.random() * 100);
  const obj = {value: i, priority: randomValue};
  queue.insert(obj);
}
let result = []
while (queue.isEmpty() == false)
  result.push(queue.remove());
console.log(result);
