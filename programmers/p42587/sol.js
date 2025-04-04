function higherCount(queue, priority) {
  let count = 0;
  for (let p of queue)
    if (Math.abs(p) > priority) ++count;
  return count;
}

function solution(queue, location) {
  queue[location] *= -1;
  let count = 0;
  while (true) {
    let p = queue.shift();
    if (p > 0) {
      if (higherCount(queue, p) === 0) ++count;
      else queue.push(p);
    } else {
      if (higherCount(queue, -p) === 0) break;
      else queue.push(p);
    }
  }
  return count + 1;
}

console.log(solution([2, 1, 3, 2], 2));
console.log(solution([1, 1, 9, 1, 1, 1], 0));
