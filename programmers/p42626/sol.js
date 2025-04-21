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

function solution(scoville, K) {
  let minHeap = new PriorityQueue((a, b) => a - b);
  for (let i of scoville) 
    minHeap.insert(i);
  while (minHeap.peek() < K) {
      if (minHeap.size() < 2) return -1;
      minHeap.insert(minHeap.remove() + minHeap.remove() * 2);
  }
  return scoville.length - minHeap.size();
}

console.log(solution([1,2,3,9,10,12], 7));
