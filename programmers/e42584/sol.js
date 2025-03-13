function solution(prices) {
  function removeLarger(stack, current) {
      while (stack.length > 0) {
          let e = stack[stack.length - 1];
          if (e.price <= current.price) return;
          answer[e.index] = current.index - e.index;
          stack.pop();
      }
  }
  let answer = [], stack = [];
  for (let i = 0; i < prices.length; ++i) {
      let current = { price: prices[i], index: i };
      removeLarger(stack, current)
      stack.push(current);
  }
  removeLarger(stack, { price: 0, index: prices.length - 1 })
  return answer;
}

console.log(solution([1, 2, 3, 2, 3]));
