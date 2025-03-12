class Queue {
  constructor() {
    this.front = 0; // 선두 항목이 들어있는 칸의 index
    this.rear = 0;  // 마지막 항목이 들어있는 직전 칸의 index
    this.storage = new Map();
  }

  size() { return this.rear - this.front; }
  add(value) { this.storage.set(this.rear++, value); }
  remove() {
    if (this.size() === 0) return;
    const value = this.storage.get(this.front);
    this.storage.delete(this.front++);
    return value;
  }
}

export default Queue;