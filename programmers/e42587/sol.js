function highCount(count, priority) {
  let result = 0;
  for (let i = priority + 1; i < count.length; ++i)
    result += count[i];
  return result;
}

function solution(priorities, location) {
  const count = new Array(10).fill(0);
  for (const p of priorities)
    count[p]++;

  priorities[location] *= -1;
  const queue = [];
  for (const p of priorities) {
    queue.push(p);
  }
  let answer = 1;
  while (true) {
    const p = queue.shift();
    if (p < 0) {
      if (highCount(count, -p) === 0) break;
      else queue.push(p);
    } else {
      if (highCount(count, p) === 0) {
        answer++;
        count[p]--;
      } else queue.push(p);
    }
  }
  return answer;
}

console.log(solution([2, 1, 3, 2], 2));
console.log(solution([1, 1, 9, 1, 1, 1], 0));
