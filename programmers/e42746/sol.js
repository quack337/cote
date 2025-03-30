function solution(numbers) {
  let list = numbers.map(String);
  list.sort((a, b) => (b + a).localeCompare(a + b));
  let result = list.join('');
  return result[0] === '0' ? '0' : result;
}

console.log(solution([6, 10, 2]));
console.log(solution([3, 30, 34, 5, 9]));
console.log(solution([0, 0]));
