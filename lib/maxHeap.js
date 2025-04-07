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
      if (this.heap[left] && this.heap[left] > this.heap[largest]) {
        largest = left;
      }
      if (this.heap[right] && this.heap[right] > this.heap[largest]) {
        largest = right;
      }
      if (largest === index) break;
      [this.heap[index], this.heap[largest]] = [this.heap[largest], this.heap[index]];
      index = largest;
    }
  }

  isEmpty() {
    return this.heap.length === 0;
  }
}

let heap = new MaxHeap();
for (let i = 0; i < 50; i++) {
  const randomValue = Math.floor(Math.random() * 100);
  heap.insert(randomValue);
}
let result = []
while (heap.isEmpty() == false)
  result.push(heap.remove());
console.log(result);
